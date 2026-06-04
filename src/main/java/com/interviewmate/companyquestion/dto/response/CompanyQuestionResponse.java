package com.interviewmate.companyquestion.dto.response;

import com.interviewmate.companyquestion.domain.CompanyQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyQuestionResponse {

    private Long companyQuestionId;
    private String companyName;
    private String jobRole;
    private String difficulty;
    private String questionContent;
    private String questionType;

    public static CompanyQuestionResponse from(
            CompanyQuestion companyQuestion
    ) {
        return new CompanyQuestionResponse(
                companyQuestion.getCompanyQuestionId(),
                companyQuestion.getCompanyName(),
                companyQuestion.getJobRole(),
                companyQuestion.getDifficulty(),
                companyQuestion.getQuestionContent(),
                companyQuestion.getQuestionType()
        );
    }
}