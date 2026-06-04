package com.interviewmate.companyquestion.mapper;

import com.interviewmate.companyquestion.domain.CompanyQuestion;
import com.interviewmate.companyquestion.dto.request.CompanyQuestionSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyQuestionMapper {

    List<CompanyQuestion> findCompanyQuestions(
            CompanyQuestionSearchRequest request
    );
}