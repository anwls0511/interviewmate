package com.interviewmate.answer.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Answer {

    private Long answerId;

    private Long interviewId;

    private Long questionId;

    private Long userId;

    private String answerText;

    private String audioUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}