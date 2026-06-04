package com.interviewmate.admin.question.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminQuestionSearchRequest {

    private String companyName;

    private String jobRole;

    private String difficulty;

    private String isActive;
}