package com.interviewmate.admin.question.mapper;

import com.interviewmate.admin.question.dto.request.AdminQuestionCreateRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionSearchRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionUpdateRequest;
import com.interviewmate.companyquestion.domain.CompanyQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminQuestionMapper {

    int insertQuestion(AdminQuestionCreateRequest request);

    int updateQuestion(
            @Param("companyQuestionId") Long companyQuestionId,
            @Param("request") AdminQuestionUpdateRequest request
    );

    int deleteQuestion(Long companyQuestionId);

    List<CompanyQuestion> findAdminQuestions(
            AdminQuestionSearchRequest request
    );

    int countAdminQuestions(AdminQuestionSearchRequest request);
}