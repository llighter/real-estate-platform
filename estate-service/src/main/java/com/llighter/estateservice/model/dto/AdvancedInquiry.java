package com.llighter.estateservice.model.dto;

import java.time.LocalDateTime;

public record AdvancedInquiry(
        Integer requestNumber,
        LocalDateTime agreedAt,
        String name,
        String dateOfBirth,
        String mobile,
        String tradeType,
        String houseType,
        String residencePeriod,
        String options
) {

}
