package com.interviewmate.answer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerResponse {

    private Long answerId;

    private Long interviewId;

    private Long questionId;

    private String status;
}