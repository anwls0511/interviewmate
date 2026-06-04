package com.interviewmate.payment.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Payment {

    private Long paymentId;

    private Long userId;

    private String planType;

    private Integer amount;

    private String status;

    private LocalDateTime paidAt;

    private LocalDateTime createdAt;
}