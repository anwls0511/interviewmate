package com.interviewmate.admin.usage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminAiUsageResponse {

    private int totalRequestCount;

    private int successCount;

    private int failCount;

    private int estimatedCost;
}