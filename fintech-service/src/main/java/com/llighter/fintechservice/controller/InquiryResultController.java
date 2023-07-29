package com.llighter.fintechservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/real-estate-compare/fintech/y-ind/advanced-inquiry-results")
public class InquiryResultController {
    @PostMapping
    public void receiveAdvancedInquiryResult(@RequestBody String result) {
        log.info("receiveAdvancedInquiryResult");
        log.info(result);
    }
}
