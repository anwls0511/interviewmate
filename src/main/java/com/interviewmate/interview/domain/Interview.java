package com.interviewmate.interview.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Interview {

    private Long interviewId;

    private Long userId;

    private String title;

    private String jobRole;

    private String careerLevel;

    private String techStack;

    private String difficulty;

    private Integer questionCount;

    private String status;

    private Integer score;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}