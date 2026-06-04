package com.interviewmate.admin.payment.mapper;

import com.interviewmate.admin.payment.dto.request.AdminPaymentSearchRequest;
import com.interviewmate.admin.payment.dto.response.AdminPaymentListResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPaymentMapper {

    List<AdminPaymentListResponse> findPayments(
            AdminPaymentSearchRequest request
    );

    int countPayments(
            AdminPaymentSearchRequest request
    );
}