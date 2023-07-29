package com.llighter.estateservice;

import com.llighter.estateservice.model.dto.InquiryResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface FintechClient {

    @PostExchange("/fintech/{code}/advanced-inquiry-results")
    ResponseEntity<Void> createAdvancedInquiryResult(@RequestBody InquiryResults inquiryResults, @PathVariable String code);
}
