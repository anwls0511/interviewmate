package com.interviewmate.admin.usage.controller;

import com.interviewmate.admin.usage.dto.AdminAiUsageResponse;
import com.interviewmate.admin.usage.service.AdminAiUsageService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/ai-usage")
public class AdminAiUsageController {

    private final AdminAiUsageService adminAiUsageService;

    @GetMapping
    public ApiResponse<AdminAiUsageResponse> getAiUsage() {

        AdminAiUsageResponse response =
                adminAiUsageService.getAiUsage();

        return ApiResponse.success(response);
    }
}