package com.interviewmate.payment.dto.response;

import com.interviewmate.payment.domain.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PaymentHistoryResponse {

    private Long paymentId;

    private String planType;

    private int amount;

    private String status;

    private LocalDateTime paidAt;

    public static PaymentHistoryResponse from(Payment payment) {
        return new PaymentHistoryResponse(
                payment.getPaymentId(),
                payment.getPlanType(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getPaidAt()
        );
    }
}