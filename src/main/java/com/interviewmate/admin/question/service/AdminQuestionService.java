package com.interviewmate.admin.question.service;

import com.interviewmate.admin.question.dto.request.AdminQuestionCreateRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionUpdateRequest;
import com.interviewmate.admin.question.dto.response.AdminQuestionResponse;
import com.interviewmate.admin.question.mapper.AdminQuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminQuestionService {

    private final AdminQuestionMapper adminQuestionMapper;

    public AdminQuestionResponse createQuestion(
            AdminQuestionCreateRequest request
    ) {
        adminQuestionMapper.insertQuestion(request);

        return new AdminQuestionResponse(
                null,
                "CREATED"
        );
    }

    public AdminQuestionResponse updateQuestion(
            Long companyQuestionId,
            AdminQuestionUpdateRequest request
    ) {
        adminQuestionMapper.updateQuestion(
                companyQuestionId,
                request
        );

        return new AdminQuestionResponse(
                companyQuestionId,
                "UPDATED"
        );
    }

    public AdminQuestionResponse deleteQuestion(
            Long companyQuestionId
    ) {
        adminQuestionMapper.deleteQuestion(companyQuestionId);

        return new AdminQuestionResponse(
                companyQuestionId,
                "DELETED"
        );
    }

}