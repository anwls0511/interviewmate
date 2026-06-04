package com.interviewmate.admin.usage.service;

import com.interviewmate.admin.usage.dto.AdminAiUsageResponse;
import com.interviewmate.admin.usage.mapper.AdminAiUsageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminAiUsageService {

    private final AdminAiUsageMapper adminAiUsageMapper;

    public AdminAiUsageResponse getAiUsage() {

        int totalRequestCount =
                adminAiUsageMapper.countTotalRequests();

        int successCount =
                adminAiUsageMapper.countSuccessRequests();

        int failCount =
                adminAiUsageMapper.countFailRequests();

        int estimatedCost = 0;

        return new AdminAiUsageResponse(
                totalRequestCount,
                successCount,
                failCount,
                estimatedCost
        );
    }
}