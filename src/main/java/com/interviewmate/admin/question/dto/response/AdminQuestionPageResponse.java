package com.interviewmate.admin.question.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AdminQuestionPageResponse {

    private int totalCount;

    private int page;

    private int size;

    private List<AdminQuestionListResponse> questions;
}