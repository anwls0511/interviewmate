package com.interviewmate.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlanResponse {

    private String planType;

    private String planName;

    private int amount;

    private String description;
}