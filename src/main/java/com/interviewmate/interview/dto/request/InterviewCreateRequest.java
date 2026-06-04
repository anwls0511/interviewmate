package com.interviewmate.interview.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewCreateRequest {

    private String title;

    private String jobRole;

    private String careerLevel;

    private String techStack;

    private String difficulty;

    private Integer questionCount;

}