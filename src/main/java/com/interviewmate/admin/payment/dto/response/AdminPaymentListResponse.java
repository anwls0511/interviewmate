package com.interviewmate.admin.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AdminPaymentListResponse {

    private Long paymentId;

    private Long userId;

    private String email;

    private String planType;

    private Integer amount;

    private String status;

    private LocalDateTime paidAt;
}