package com.interviewmate.admin.question.dto.response;

import com.interviewmate.companyquestion.domain.CompanyQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminQuestionListResponse {

    private Long companyQuestionId;

    private String companyName;

    private String jobRole;

    private String difficulty;

    private String questionContent;

    private String questionType;

    private String isActive;

    public static AdminQuestionListResponse from(
            CompanyQuestion companyQuestion
    ) {
        return new AdminQuestionListResponse(
                companyQuestion.getCompanyQuestionId(),
                companyQuestion.getCompanyName(),
                companyQuestion.getJobRole(),
                companyQuestion.getDifficulty(),
                companyQuestion.getQuestionContent(),
                companyQuestion.getQuestionType(),
                companyQuestion.getIsActive()
        );
    }
}