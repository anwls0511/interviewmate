package com.interviewmate.question.controller;

import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.question.dto.response.QuestionResponse;
import com.interviewmate.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ApiResponse<List<QuestionResponse>> getQuestions(
            @PathVariable Long interviewId
    ) {
        List<QuestionResponse> response =
                questionService.getQuestions(interviewId);

        return ApiResponse.success(response);
    }
}