package com.interviewmate.admin.payment.service;

import com.interviewmate.admin.payment.dto.request.AdminPaymentSearchRequest;
import com.interviewmate.admin.payment.dto.response.AdminPaymentListResponse;
import com.interviewmate.admin.payment.mapper.AdminPaymentMapper;
import com.interviewmate.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminPaymentService {

    private final AdminPaymentMapper adminPaymentMapper;

    public PageResponse<AdminPaymentListResponse> getPayments(
            AdminPaymentSearchRequest request
    ) {
        int totalCount =
                adminPaymentMapper.countPayments(request);

        List<AdminPaymentListResponse> payments =
                adminPaymentMapper.findPayments(request);

        return new PageResponse<>(
                totalCount,
                request.getPage(),
                request.getSize(),
                payments
        );
    }
}