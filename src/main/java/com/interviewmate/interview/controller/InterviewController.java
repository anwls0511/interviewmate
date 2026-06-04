package com.interviewmate.interview.controller;

import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.interview.dto.request.InterviewCreateRequest;
import com.interviewmate.interview.dto.response.InterviewResponse;
import com.interviewmate.interview.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public ApiResponse<InterviewResponse>
    createInterview(
            Authentication authentication,
            @RequestBody InterviewCreateRequest request
    ) {

        Long userId =
                (Long) authentication.getPrincipal();

        InterviewResponse response =
                interviewService.createInterview(
                        userId,
                        request
                );

        return ApiResponse.success(
                "면접이 생성되었습니다.",
                response
        );

    }
}
