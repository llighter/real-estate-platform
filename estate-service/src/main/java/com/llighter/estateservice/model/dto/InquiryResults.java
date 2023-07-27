package com.llighter.estateservice.model.dto;

import com.llighter.estateservice.model.Items;

import java.util.List;

public record InquiryResults(
        Integer requestNumber,
        Iterable<Items> prequalifiedItems
) {
}
