package com.llighter.estateservice.model.dto;

import java.util.Objects;

public record ApplyRequest(
        Integer requestNumber,
        Integer affiliateCustomerManagementNumber
) {
    public ApplyRequest {
        Objects.requireNonNull(requestNumber);
        Objects.requireNonNull(affiliateCustomerManagementNumber);
    }
}
