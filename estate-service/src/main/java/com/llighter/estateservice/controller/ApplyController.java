package com.llighter.estateservice.controller;

import com.llighter.estateservice.model.dto.ApplyRequest;
import com.llighter.estateservice.model.dto.Result;
import com.llighter.estateservice.service.ApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/seoul-real-estate/apply")
public class ApplyController {

    private final ApplyService applyService;

    @PostMapping
    public Result<String> apply(@RequestBody ApplyRequest applyRequest) {

        applyService.apply(applyRequest);

        return Result.success();
    }
}
