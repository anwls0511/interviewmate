package com.interviewmate.admin.question.mapper;

import com.interviewmate.admin.question.dto.request.AdminQuestionCreateRequest;
import com.interviewmate.admin.question.dto.request.AdminQuestionUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminQuestionMapper {

    int insertQuestion(AdminQuestionCreateRequest request);

    int updateQuestion(
            @Param("companyQuestionId") Long companyQuestionId,
            @Param("request") AdminQuestionUpdateRequest request
    );

    int deleteQuestion(Long companyQuestionId);
}