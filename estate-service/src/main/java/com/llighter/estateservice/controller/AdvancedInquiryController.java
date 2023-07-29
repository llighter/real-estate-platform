package com.llighter.estateservice.controller;

import com.llighter.estateservice.model.dto.AdvancedInquiry;
import com.llighter.estateservice.model.dto.Result;
import com.llighter.estateservice.service.AdvancedInquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@EnableAsync
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/seoul-real-estate/advance-inquiry")
public class AdvancedInquiryController {

    private final AdvancedInquiryService advancedInquiryService;

    @PostMapping
    public Result<String> advancedInquiry(@RequestBody AdvancedInquiry advancedInquiry) {
        // TODO: 예외발생 시 오류 메시지 및 코드 처리 필요
        advancedInquiryService.inquiry(advancedInquiry);

        return Result.success();
    }
}
