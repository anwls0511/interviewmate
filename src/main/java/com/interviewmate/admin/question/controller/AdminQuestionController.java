package com.interviewmate.admin.question.controller;

import com.interviewmate.admin.question.dto.request.AdminQuestionCreateRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionUpdateRequest;
import com.interviewmate.admin.question.dto.response.AdminQuestionResponse;
import com.interviewmate.admin.question.service.AdminQuestionService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/questions")
public class AdminQuestionController {

    private final AdminQuestionService adminQuestionService;

    @PostMapping
    public ApiResponse<AdminQuestionResponse> createQuestion(
            @RequestBody AdminQuestionCreateRequest request
    ) {
        AdminQuestionResponse response =
                adminQuestionService.createQuestion(request);

        return ApiResponse.success(
                "질문이 등록되었습니다.",
                response
        );
    }

    @PutMapping("/{companyQuestionId}")
    public ApiResponse<AdminQuestionResponse> updateQuestion(
            @PathVariable Long companyQuestionId,
            @RequestBody AdminQuestionUpdateRequest request
    ) {
        AdminQuestionResponse response =
                adminQuestionService.updateQuestion(
                        companyQuestionId,
                        request
                );

        return ApiResponse.success(
                "질문이 수정되었습니다.",
                response
        );
    }
}