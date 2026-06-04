package com.interviewmate.admin.question.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminQuestionUpdateRequest {

    private String companyName;

    private String jobRole;

    private String difficulty;

    private String questionContent;

    private String questionType;

    private String isActive;
}