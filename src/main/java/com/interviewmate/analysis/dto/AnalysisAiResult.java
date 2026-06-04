package com.interviewmate.analysis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnalysisAiResult {

    private Integer professionalismScore;
    private Integer logicScore;
    private Integer communicationScore;
    private Integer totalScore;
    private String feedback;
    private String improvementAnswer;
}