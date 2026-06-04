package com.interviewmate.admin.dashboard.controller;

import com.interviewmate.admin.dashboard.dto.AdminDashboardResponse;
import com.interviewmate.admin.dashboard.service.AdminDashboardService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/metrics")
public class AdminDashboardController {

    private final AdminDashboardService adminDashboardService;

    @GetMapping
    public ApiResponse<AdminDashboardResponse> getMetrics() {

        AdminDashboardResponse response =
                adminDashboardService.getMetrics();

        return ApiResponse.success(response);
    }
}