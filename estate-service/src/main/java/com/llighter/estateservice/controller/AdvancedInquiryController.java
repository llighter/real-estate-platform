package com.llighter.estateservice.controller;

import com.llighter.estateservice.model.Customer;
import com.llighter.estateservice.model.dto.AdvancedInquiry;
import com.llighter.estateservice.model.dto.InquiryResults;
import com.llighter.estateservice.repository.CustomerRepository;
import com.llighter.estateservice.repository.ItemsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/seoul-real-estate/advance-inquiry")
public class AdvancedInquiryController {

    private final CustomerRepository customers;
    private final ItemsRepository items;

    public AdvancedInquiryController(CustomerRepository customers, ItemsRepository items) {
        this.customers = customers;
        this.items = items;
    }

    @PostMapping
    public InquiryResults advancedInquiry(@RequestBody AdvancedInquiry advancedInquiry) {
        // TODO: 고객의 이름과 휴대폰번호로 기존 등록된 고객이 존재하는지 체크하고 존재하지 않으면 등록
        customers.findById(1).orElseGet(() -> customers.save(new Customer("John", "1990-01-01", "1234567890")));

        return new InquiryResults(1, items.findAll()) ;
    }
}
