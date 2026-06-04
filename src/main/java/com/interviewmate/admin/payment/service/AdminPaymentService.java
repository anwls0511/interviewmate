package com.interviewmate.admin.payment.service;

import com.interviewmate.admin.payment.dto.request.AdminPaymentSearchRequest;
import com.interviewmate.admin.payment.dto.response.AdminPaymentListResponse;
import com.interviewmate.admin.payment.mapper.AdminPaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminPaymentService {

    private final AdminPaymentMapper adminPaymentMapper;

    public List<AdminPaymentListResponse> getPayments(
            AdminPaymentSearchRequest request
    ) {
        return adminPaymentMapper.findPayments(request);
    }
}