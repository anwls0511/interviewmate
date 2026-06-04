package com.interviewmate.analysis.dto.response;

import com.interviewmate.analysis.domain.Analysis;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnalysisResultResponse {

    private Integer professionalismScore;

    private Integer logicScore;

    private Integer communicationScore;

    private Integer totalScore;

    private String feedback;

    private String improvementAnswer;

    private String status;

    public static AnalysisResultResponse from(
            Analysis analysis
    ) {

        return new AnalysisResultResponse(
                analysis.getProfessionalismScore(),
                analysis.getLogicScore(),
                analysis.getCommunicationScore(),
                analysis.getTotalScore(),
                analysis.getFeedback(),
                analysis.getImprovementAnswer(),
                analysis.getStatus()
        );

    }

}