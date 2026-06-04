package com.interviewmate.admin.payment.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminPaymentSearchRequest {

    private String email;

    private String planType;

    private String status;
}