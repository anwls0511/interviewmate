package com.interviewmate.answer.mapper;

import com.interviewmate.answer.domain.Answer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {

    int insertAnswer(Answer answer);

    Answer findById(Long answerId);

}