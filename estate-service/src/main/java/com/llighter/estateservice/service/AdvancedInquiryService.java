package com.llighter.estateservice.service;

import com.llighter.estateservice.FintechClient;
import com.llighter.estateservice.model.AffiliateCustomerManagement;
import com.llighter.estateservice.model.Customer;
import com.llighter.estateservice.model.Items;
import com.llighter.estateservice.model.dto.AdvancedInquiry;
import com.llighter.estateservice.model.dto.InquiryResults;
import com.llighter.estateservice.repository.AffiliateCustomerManagementRepository;
import com.llighter.estateservice.repository.CustomerRepository;
import com.llighter.estateservice.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdvancedInquiryService {

    private final ItemsRepository items;
    private final CustomerRepository customers;
    private final AffiliateCustomerManagementRepository affiliateCustomerManagementRepository;
    private final FintechClient fintechClient;

    @Async
    @Transactional
    public void inquiry(AdvancedInquiry advancedInquiry) {

        // 이름과 휴대폰번호로 고객 검색
        Customer customer = customers.findByNameAndMobile(advancedInquiry.name(), advancedInquiry.mobile())
                // 고객이 존재하지 않으면 새로운 고객 등록
                .orElseGet(() -> {
                    return customers.save(new Customer(advancedInquiry.name(), advancedInquiry.dateOfBirth(), advancedInquiry.mobile()));
                });
        log.info("고객: {}", customer);

        // items 테이블에서 전체 목록을 가져와서 상품정보와 일치하는 상품을 찾음
        Iterable<Items> itemsAll = items.findAll();

        List<Items> items = StreamSupport.stream(itemsAll.spliterator(), false)
                .filter(item -> item.getOption().equals(advancedInquiry.options()))
                .filter(item -> item.getTradeType().equals(advancedInquiry.tradeType()))
                .filter(item -> item.getHouseType().equals(advancedInquiry.houseType()))
                .filter(item -> item.getResidencePeriod().equals(advancedInquiry.residencePeriod()))
                .toList();
        log.info("상품: {}", items);

        // 조회된 상품을 제휴고객관리에 등록
        items.forEach(item -> {
            AggregateReference<Items, Integer> itemRef = AggregateReference.to(item.getId());
            AggregateReference<Customer, Integer> customerRef = AggregateReference.to(customer.getId());

            affiliateCustomerManagementRepository.save(new AffiliateCustomerManagement(customerRef, itemRef));
        });

        InquiryResults inquiryResults = InquiryResults.from(advancedInquiry.requestNumber(), items);
        ResponseEntity<Void> advancedInquiryResult = fintechClient.createAdvancedInquiryResult(inquiryResults, "y-ind");
        log.info("고객 조회 결과: {}", advancedInquiryResult);

    }
}
