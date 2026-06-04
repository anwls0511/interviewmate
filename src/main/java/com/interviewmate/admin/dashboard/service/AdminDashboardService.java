package com.interviewmate.admin.dashboard.service;

import com.interviewmate.admin.dashboard.dto.AdminDashboardResponse;
import com.interviewmate.admin.dashboard.mapper.AdminDashboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDashboardService {

    private final AdminDashboardMapper adminDashboardMapper;

    public AdminDashboardResponse getMetrics() {

        int totalUserCount =
                adminDashboardMapper.countUsers();

        int totalInterviewCount =
                adminDashboardMapper.countInterviews();

        int totalAnalysisCount =
                adminDashboardMapper.countAnalysis();

        int monthlyRevenue =
                adminDashboardMapper.getMonthlyRevenue();

        return new AdminDashboardResponse(
                totalUserCount,
                totalInterviewCount,
                totalAnalysisCount,
                monthlyRevenue
        );
    }
}