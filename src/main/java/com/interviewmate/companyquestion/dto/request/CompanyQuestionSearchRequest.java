package com.interviewmate.companyquestion.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyQuestionSearchRequest {

    private String companyName;
    private String jobRole;
    private String difficulty;
}