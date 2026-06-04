package com.interviewmate.interview.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InterviewFinishResponse {

    private Long interviewId;

    private String status;
}