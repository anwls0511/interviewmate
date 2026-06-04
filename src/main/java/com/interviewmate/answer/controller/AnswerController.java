package com.interviewmate.answer.controller;

import com.interviewmate.answer.dto.request.AnswerCreateRequest;
import com.interviewmate.answer.dto.response.AnswerResponse;
import com.interviewmate.answer.service.AnswerService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/answers")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ApiResponse<AnswerResponse> createAnswer(Authentication authentication, @PathVariable Long interviewId, @RequestBody AnswerCreateRequest request) {
        Long userId = (Long) authentication.getPrincipal();

        AnswerResponse response = answerService.createAnswer(userId, interviewId, request);

        return ApiResponse.success("답변이 저장되었습니다.", response);
    }
}