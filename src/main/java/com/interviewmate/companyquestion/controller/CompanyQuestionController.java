package com.interviewmate.companyquestion.controller;

import com.interviewmate.companyquestion.dto.request.CompanyQuestionSearchRequest;
import com.interviewmate.companyquestion.dto.response.CompanyQuestionResponse;
import com.interviewmate.companyquestion.service.CompanyQuestionService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company-questions")
public class CompanyQuestionController {

    private final CompanyQuestionService companyQuestionService;

    @GetMapping
    public ApiResponse<List<CompanyQuestionResponse>> getCompanyQuestions(
            @ModelAttribute CompanyQuestionSearchRequest request
    ) {
        List<CompanyQuestionResponse> response =
                companyQuestionService.getCompanyQuestions(request);

        return ApiResponse.success(response);
    }
}