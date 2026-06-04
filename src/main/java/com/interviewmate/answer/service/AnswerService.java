package com.interviewmate.answer.service;

import com.interviewmate.answer.domain.Answer;
import com.interviewmate.answer.dto.request.AnswerCreateRequest;
import com.interviewmate.answer.dto.response.AnswerResponse;
import com.interviewmate.answer.mapper.AnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.interviewmate.analysis.dto.AnalysisMessage;
import com.interviewmate.analysis.producer.AnalysisProducer;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerMapper answerMapper;
    private final AnalysisProducer analysisProducer;

    public AnswerResponse createAnswer(
            Long userId,
            Long interviewId,
            AnswerCreateRequest request

    ) {
        Answer answer = new Answer();

        answer.setUserId(userId);
        answer.setInterviewId(interviewId);
        answer.setQuestionId(request.getQuestionId());
        answer.setAnswerText(request.getAnswerText());
        answer.setAudioUrl(request.getAudioUrl());

        answerMapper.insertAnswer(answer);

        AnalysisMessage message = new AnalysisMessage();

        message.setInterviewId(answer.getInterviewId());
        message.setAnswerId(answer.getAnswerId());
        message.setUserId(answer.getUserId());

        analysisProducer.send(message);

        return new AnswerResponse(
                answer.getAnswerId(),
                answer.getInterviewId(),
                answer.getQuestionId(),
                "SAVED"
        );
    }
}