package com.interviewmate.question.mapper;

import com.interviewmate.question.domain.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    int insertQuestion(Question question);

    List<Question> findByInterviewId(Long interviewId);
}