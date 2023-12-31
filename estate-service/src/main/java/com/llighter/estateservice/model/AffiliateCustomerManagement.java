package com.llighter.estateservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
public class AffiliateCustomerManagement {
    @Id
    private Integer id;
    // 진행단계(조회:001, 거절:002, 신청:003, 승인:004)
    private String progressStep;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @Column("CUSTOMER_ID")
    private AggregateReference<Customer, Integer> customer;
    @Column("ITEM_ID")
    private AggregateReference<Items, Integer> item;

    public AffiliateCustomerManagement(AggregateReference<Customer, Integer> customer, AggregateReference<Items, Integer> item) {
        this.customer = customer;
        this.item = item;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
        this.progressStep = "001"; // 조회
    }

    // 거절 요청이 들어오면 진행단계를 거절로 변경
    public void reject() {
        this.progressStep = "002";
    }

    // 신청 요청이 들어오면 진행단계를 신청으로 변경
    public void apply() {
        // 신청가능한 상태(조회)인 경우 신청처리를 진행하고 아닌 경우 예외처리
        if (this.progressStep.equals("001")) {
            this.progressStep = "003";
        } else {
            throw new IllegalStateException("신청할 수 없는 상태입니다.");
        }
    }

    // 승인 요청이 들어오면 진행단계를 승인으로 변경
    public void approve() {
        this.progressStep = "004";
    }

}
