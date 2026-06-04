package com.interviewmate.payment.mapper;

import com.interviewmate.payment.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    int insertPayment(Payment payment);

    List<Payment> findByUserId(Long userId);
}