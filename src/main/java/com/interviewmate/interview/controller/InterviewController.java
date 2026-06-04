package com.interviewmate.interview.controller;

import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.interview.dto.request.InterviewCreateRequest;
import com.interviewmate.interview.dto.response.InterviewDetailResponse;
import com.interviewmate.interview.dto.response.InterviewFinishResponse;
import com.interviewmate.interview.dto.response.InterviewListResponse;
import com.interviewmate.interview.dto.response.InterviewResponse;
import com.interviewmate.interview.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

//    @PostMapping
//    public ApiResponse<InterviewResponse>
//    createInterview(
//            Authentication authentication,
//            @RequestBody InterviewCreateRequest request
//    ) {
//
//        Long userId =
//                (Long) authentication.getPrincipal();
//
//        InterviewResponse response =
//                interviewService.createInterview(
//                        userId,
//                        request
//                );
//
//        return ApiResponse.success(
//                "면접이 생성되었습니다.",
//                response
//        );
//
//    }

    @PostMapping
    public ApiResponse<InterviewResponse> createInterview(
            Authentication authentication,
            @Valid @RequestBody InterviewCreateRequest request
    ) {
        Long userId = (Long) authentication.getPrincipal();

        InterviewResponse response =
                interviewService.createInterview(userId, request);

        return ApiResponse.success(
                "면접이 생성되었습니다.",
                response
        );
    }

    @GetMapping
    public ApiResponse<List<InterviewListResponse>> getMyInterviews(
            Authentication authentication
    ) {
        Long userId = (Long) authentication.getPrincipal();

        List<InterviewListResponse> response =
                interviewService.getMyInterviews(userId);

        return ApiResponse.success(response);
    }

    @GetMapping("/{interviewId}")
    public ApiResponse<InterviewDetailResponse>
    getInterviewDetail(
            @PathVariable Long interviewId
    ) {

        InterviewDetailResponse response =
                interviewService.getInterviewDetail(
                        interviewId
                );

        return ApiResponse.success(
                response
        );

    }

    @PatchMapping("/{interviewId}/finish")
    public ApiResponse<InterviewFinishResponse> finishInterview(
            @PathVariable Long interviewId
    ) {
        InterviewFinishResponse response =
                interviewService.finishInterview(interviewId);

        return ApiResponse.success(
                "면접이 종료되었습니다.",
                response
        );
    }


}
