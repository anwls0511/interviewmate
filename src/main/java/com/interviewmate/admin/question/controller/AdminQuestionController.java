package com.interviewmate.admin.question.controller;

import com.interviewmate.admin.question.dto.request.AdminQuestionCreateRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionSearchRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionUpdateRequest;
import com.interviewmate.admin.question.dto.response.AdminQuestionListResponse;
import com.interviewmate.admin.question.dto.response.AdminQuestionResponse;
import com.interviewmate.admin.question.service.AdminQuestionService;
import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/questions")
public class AdminQuestionController {

    private final AdminQuestionService adminQuestionService;

    @GetMapping
    public ApiResponse<PageResponse<AdminQuestionListResponse>> getQuestions(
            @ModelAttribute AdminQuestionSearchRequest request
    ) {
        PageResponse<AdminQuestionListResponse> response =
                adminQuestionService.getQuestions(request);

        return ApiResponse.success(response);
    }

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

    @DeleteMapping("/{companyQuestionId}")
    public ApiResponse<AdminQuestionResponse> deleteQuestion(
            @PathVariable Long companyQuestionId
    ) {
        AdminQuestionResponse response =
                adminQuestionService.deleteQuestion(
                        companyQuestionId
                );

        return ApiResponse.success(
                "질문이 삭제되었습니다.",
                response
        );
    }
}