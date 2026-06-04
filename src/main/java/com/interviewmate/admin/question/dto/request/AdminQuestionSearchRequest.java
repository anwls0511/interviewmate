package com.interviewmate.admin.question.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminQuestionSearchRequest {

    private String companyName;

    private String jobRole;

    private String difficulty;

    private String isActive;

    @Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다.")
    private Integer page = 1;

    @Min(value = 1, message = "페이지 크기는 1 이상이어야 합니다.")
    @Max(value = 100, message = "페이지 크기는 최대 100까지 가능합니다.")
    private Integer size = 10;

    public int getOffset() {
        return (page - 1) * size;
    }
}