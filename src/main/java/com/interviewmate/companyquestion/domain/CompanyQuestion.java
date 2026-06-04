package com.interviewmate.companyquestion.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CompanyQuestion {

    private Long companyQuestionId;
    private String companyName;
    private String jobRole;
    private String difficulty;
    private String questionContent;
    private String questionType;
    private String isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}