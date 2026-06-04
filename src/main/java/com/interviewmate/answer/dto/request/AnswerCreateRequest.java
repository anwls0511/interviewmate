package com.interviewmate.answer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerCreateRequest {

    private Long questionId;

    private String answerText;

    private String audioUrl;
}