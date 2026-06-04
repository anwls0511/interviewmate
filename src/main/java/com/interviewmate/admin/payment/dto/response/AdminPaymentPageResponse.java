package com.interviewmate.admin.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AdminPaymentPageResponse {

    private int totalCount;

    private int page;

    private int size;

    private List<AdminPaymentListResponse> payments;
}