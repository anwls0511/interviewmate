package com.interviewmate.dashboard.dto;

import com.interviewmate.interview.dto.response.InterviewListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DashboardResponse {

    private int totalInterviewCount;

    private int averageScore;

    private List<InterviewListResponse> recentInterviews;
}