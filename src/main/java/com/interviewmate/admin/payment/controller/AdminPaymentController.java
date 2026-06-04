package com.interviewmate.admin.payment.controller;

import com.interviewmate.admin.payment.dto.request.AdminPaymentSearchRequest;
import com.interviewmate.admin.payment.dto.response.AdminPaymentPageResponse;
import com.interviewmate.admin.payment.service.AdminPaymentService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/payments")
public class AdminPaymentController {

    private final AdminPaymentService adminPaymentService;

    @GetMapping
    public ApiResponse<AdminPaymentPageResponse> getPayments(
            @ModelAttribute AdminPaymentSearchRequest request
    ) {
        AdminPaymentPageResponse response =
                adminPaymentService.getPayments(request);

        return ApiResponse.success(response);
    }
}