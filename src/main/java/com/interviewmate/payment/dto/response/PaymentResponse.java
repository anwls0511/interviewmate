package com.interviewmate.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentResponse {

    private Long paymentId;

    private String planType;

    private int amount;

    private String status;
}