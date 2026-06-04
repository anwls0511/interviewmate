package com.interviewmate.question.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Question {

    private Long questionId;
    private Long interviewId;
    private String content;
    private Integer questionOrder;
    private String difficulty;
    private String questionType;
    private LocalDateTime createdAt;
}