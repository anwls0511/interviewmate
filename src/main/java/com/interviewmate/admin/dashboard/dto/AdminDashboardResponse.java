package com.interviewmate.admin.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminDashboardResponse {

    private int totalUserCount;

    private int totalInterviewCount;

    private int totalAnalysisCount;

    private int monthlyRevenue;
}