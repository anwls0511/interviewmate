package com.interviewmate.dashboard.service;

import com.interviewmate.dashboard.dto.DashboardResponse;
import com.interviewmate.dashboard.mapper.DashboardMapper;
import com.interviewmate.interview.dto.response.InterviewListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final DashboardMapper dashboardMapper;

    public DashboardResponse getDashboard(Long userId) {

        int totalInterviewCount =
                dashboardMapper.countByUserId(userId);

        Integer averageScore =
                dashboardMapper.averageScoreByUserId(userId);

        List<InterviewListResponse> recentInterviews =
                dashboardMapper.findRecentByUserId(userId)
                        .stream()
                        .map(InterviewListResponse::from)
                        .toList();

        return new DashboardResponse(
                totalInterviewCount,
                averageScore == null ? 0 : averageScore,
                recentInterviews
        );
    }
}