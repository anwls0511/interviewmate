package com.interviewmate.payment.controller;

import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.payment.dto.request.PaymentSubscribeRequest;
import com.interviewmate.payment.dto.response.PaymentHistoryResponse;
import com.interviewmate.payment.dto.response.PaymentResponse;
import com.interviewmate.payment.dto.response.PlanResponse;
import com.interviewmate.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/api/plans")
    public ApiResponse<List<PlanResponse>> getPlans() {

        List<PlanResponse> response =
                paymentService.getPlans();

        return ApiResponse.success(response);
    }

    @PostMapping("/api/payments/subscribe")
    public ApiResponse<PaymentResponse> subscribe(
            Authentication authentication,
            @RequestBody PaymentSubscribeRequest request
    ) {
        Long userId = (Long) authentication.getPrincipal();

        PaymentResponse response =
                paymentService.subscribe(
                        userId,
                        request
                );

        return ApiResponse.success(
                "구독이 완료되었습니다.",
                response
        );
    }

    @GetMapping("/api/payments/history")
    public ApiResponse<List<PaymentHistoryResponse>> getPaymentHistory(
            Authentication authentication
    ) {
        Long userId = (Long) authentication.getPrincipal();

        List<PaymentHistoryResponse> response =
                paymentService.getPaymentHistory(userId);

        return ApiResponse.success(response);
    }
}