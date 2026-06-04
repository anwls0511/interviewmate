package com.interviewmate.analysis.service;

import com.interviewmate.analysis.domain.Analysis;
import com.interviewmate.analysis.dto.AnalysisAiResult;
import com.interviewmate.analysis.dto.AnalysisMessage;
import com.interviewmate.analysis.dto.response.AnalysisResultResponse;
import com.interviewmate.analysis.mapper.AnalysisMapper;
import com.interviewmate.analysis.openai.OpenAiService;
import com.interviewmate.answer.domain.Answer;
import com.interviewmate.answer.mapper.AnswerMapper;
import com.interviewmate.global.exception.BusinessException;
import com.interviewmate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisMapper analysisMapper;
    private final AnswerMapper answerMapper;
    private final OpenAiService openAiService;

    public void analyze(AnalysisMessage message) {

        Answer answer = answerMapper.findById(message.getAnswerId());

        if (answer == null) {
            throw new BusinessException(ErrorCode.ANSWER_NOT_FOUND);
        }

        AnalysisAiResult aiResult =
                openAiService.analyzeAnswer(answer.getAnswerText());

        Analysis analysis = new Analysis();

        analysis.setInterviewId(message.getInterviewId());
        analysis.setAnswerId(message.getAnswerId());
        analysis.setUserId(message.getUserId());
        analysis.setProfessionalismScore(aiResult.getProfessionalismScore());
        analysis.setLogicScore(aiResult.getLogicScore());
        analysis.setCommunicationScore(aiResult.getCommunicationScore());
        analysis.setTotalScore(aiResult.getTotalScore());
        analysis.setFeedback(aiResult.getFeedback());
        analysis.setImprovementAnswer(aiResult.getImprovementAnswer());
        analysis.setStatus("COMPLETED");

        analysisMapper.insertAnalysis(analysis);
    }

    public AnalysisResultResponse getResult(Long interviewId) {

        Analysis analysis =
                analysisMapper.findByInterviewId(interviewId);

        if (analysis == null) {
            throw new BusinessException(ErrorCode.ANALYSIS_NOT_FOUND);
        }

        return AnalysisResultResponse.from(analysis);
    }
}