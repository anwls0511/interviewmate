package com.interviewmate.analysis.controller;

import com.interviewmate.analysis.dto.response.AnalysisResultResponse;
import com.interviewmate.analysis.service.AnalysisService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interviews")
public class AnalysisController {

    private final AnalysisService analysisService;

    @GetMapping("/{interviewId}/result")
    public ApiResponse<AnalysisResultResponse> getResult(
            @PathVariable Long interviewId
    ) {

        AnalysisResultResponse response =
                analysisService.getResult(
                        interviewId
                );

        return ApiResponse.success(
                response
        );

    }

}