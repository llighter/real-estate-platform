package com.llighter.estateservice.model.dto;

import com.llighter.estateservice.model.Items;

import java.util.List;

public record InquiryResults(
        Integer requestNumber,
        List<PreQualifiedProduct> preQualifiedProduct
) {
    public record PreQualifiedProduct (
            Integer affiliateCustomerManagementNumber,
            String ProductName,
            Integer price
    ) {}

    public static InquiryResults from(Integer requestNumber, List<Items> items) {
        return new InquiryResults(
                requestNumber,
                items.stream()
                        .map(item -> new PreQualifiedProduct(
                                item.getId(),
                                item.getItemName(),
                                item.getPrice()
                        ))
                        .toList()
        );
    }
}
