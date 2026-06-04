package com.interviewmate.interview.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InterviewResponse {

    private Long interviewId;

    private String title;

    private String status;

}