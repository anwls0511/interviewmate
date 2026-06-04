package com.interviewmate.analysis.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Analysis {

    private Long analysisId;

    private Long interviewId;

    private Long answerId;

    private Long userId;

    private Integer professionalismScore;

    private Integer logicScore;

    private Integer communicationScore;

    private Integer totalScore;

    private String feedback;

    private String improvementAnswer;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}