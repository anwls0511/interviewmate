package com.interviewmate.interview.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewCreateRequest {

    @NotBlank(message = "면접 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "직무는 필수입니다.")
    private String jobRole;

    @NotBlank(message = "경력 수준은 필수입니다.")
    private String careerLevel;

    @NotBlank(message = "기술스택은 필수입니다.")
    private String techStack;

    @NotBlank(message = "난이도는 필수입니다.")
    private String difficulty;

    @NotNull(message = "질문 수는 필수입니다.")
    @Min(value = 1, message = "질문 수는 최소 1개 이상이어야 합니다.")
    @Max(value = 20, message = "질문 수는 최대 20개까지 가능합니다.")
    private Integer questionCount;
}