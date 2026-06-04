package com.interviewmate.admin.question.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminQuestionResponse {

    private Long companyQuestionId;

    private String status;
}