package com.interviewmate.companyquestion.service;

import com.interviewmate.companyquestion.dto.request.CompanyQuestionSearchRequest;
import com.interviewmate.companyquestion.dto.response.CompanyQuestionResponse;
import com.interviewmate.companyquestion.mapper.CompanyQuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyQuestionService {

    private final CompanyQuestionMapper companyQuestionMapper;

    public List<CompanyQuestionResponse> getCompanyQuestions(
            CompanyQuestionSearchRequest request
    ) {
        return companyQuestionMapper.findCompanyQuestions(request)
                .stream()
                .map(CompanyQuestionResponse::from)
                .toList();
    }
}