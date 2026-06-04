package com.interviewmate.report.service;

import com.interviewmate.analysis.domain.Analysis;
import com.interviewmate.analysis.mapper.AnalysisMapper;
import com.interviewmate.global.exception.BusinessException;
import com.interviewmate.global.exception.ErrorCode;
import com.interviewmate.interview.domain.Interview;
import com.interviewmate.interview.mapper.InterviewMapper;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final InterviewMapper interviewMapper;

    private final AnalysisMapper analysisMapper;

    public byte[] createInterviewReport(
            Long interviewId
    ) {
        Interview interview =
                interviewMapper.findById(interviewId);

        if (interview == null) {
            throw new BusinessException(
                    ErrorCode.INTERVIEW_NOT_FOUND
            );
        }

        Analysis analysis =
                analysisMapper.findByInterviewId(interviewId);

        if (analysis == null) {
            throw new BusinessException(
                    ErrorCode.ANALYSIS_NOT_FOUND
            );
        }

        String html = createHtml(
                interview,
                analysis
        );

        try (
                ByteArrayOutputStream outputStream =
                        new ByteArrayOutputStream()
        ) {
            PdfRendererBuilder builder =
                    new PdfRendererBuilder();

            builder.useFastMode();

            builder.withHtmlContent(
                    html,
                    null
            );

            builder.toStream(
                    outputStream
            );

            builder.run();

            return outputStream.toByteArray();

        } catch (Exception e) {
            throw new BusinessException(ErrorCode.REPORT_CREATE_FAILED);
        }
    }

    private String createHtml(
            Interview interview,
            Analysis analysis
    ) {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8"/>
                    <style>
                        body {
                            font-family: sans-serif;
                            padding: 32px;
                            color: #111827;
                        }
                        .title {
                            font-size: 28px;
                            font-weight: bold;
                            margin-bottom: 8px;
                        }
                        .subtitle {
                            color: #6b7280;
                            margin-bottom: 32px;
                        }
                        .card {
                            border: 1px solid #e5e7eb;
                            border-radius: 12px;
                            padding: 20px;
                            margin-bottom: 20px;
                        }
                        .score {
                            font-size: 42px;
                            font-weight: bold;
                            color: #2563eb;
                        }
                        .grid {
                            display: grid;
                            grid-template-columns: repeat(3, 1fr);
                            gap: 12px;
                        }
                        .label {
                            color: #6b7280;
                            font-size: 13px;
                        }
                        .value {
                            font-size: 18px;
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                    <div class="title">Interview Mate 면접 결과 리포트</div>
                    <div class="subtitle">AI 기반 모의면접 분석 결과</div>

                    <div class="card">
                        <div class="label">면접명</div>
                        <div class="value">%s</div>
                    </div>

                    <div class="card">
                        <div class="label">종합 점수</div>
                        <div class="score">%d점</div>
                    </div>

                    <div class="card">
                        <div class="grid">
                            <div>
                                <div class="label">전문성</div>
                                <div class="value">%d점</div>
                            </div>
                            <div>
                                <div class="label">논리성</div>
                                <div class="value">%d점</div>
                            </div>
                            <div>
                                <div class="label">전달력</div>
                                <div class="value">%d점</div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="label">AI 피드백</div>
                        <p>%s</p>
                    </div>

                    <div class="card">
                        <div class="label">개선 답변 예시</div>
                        <p>%s</p>
                    </div>
                </body>
                </html>
                """.formatted(
                interview.getTitle(),
                analysis.getTotalScore(),
                analysis.getProfessionalismScore(),
                analysis.getLogicScore(),
                analysis.getCommunicationScore(),
                analysis.getFeedback(),
                analysis.getImprovementAnswer()
        );
    }
}