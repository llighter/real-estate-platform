package com.llighter.estateservice.service;

import com.llighter.estateservice.exception.NoDataFoundException;
import com.llighter.estateservice.model.AffiliateCustomerManagement;
import com.llighter.estateservice.model.dto.ApplyRequest;
import com.llighter.estateservice.repository.AffiliateCustomerManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final AffiliateCustomerManagementRepository affiliateCustomerManagementRepository;

    @Transactional
    public void apply(ApplyRequest applyRequest) {
        // 제휴고객관리 조회
        AffiliateCustomerManagement management = affiliateCustomerManagementRepository.findById(applyRequest.affiliateCustomerManagementNumber())
                .orElseThrow(() -> new NoDataFoundException("제휴고객관리 조회 실패"));

        management.apply();
        affiliateCustomerManagementRepository.save(management);
    }
}
