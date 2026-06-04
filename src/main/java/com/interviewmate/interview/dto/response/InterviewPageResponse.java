package com.interviewmate.interview.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class InterviewPageResponse {

    private int totalCount;

    private int page;

    private int size;

    private List<InterviewListResponse> interviews;
}