package com.interviewmate.payment.service;

import com.interviewmate.payment.domain.Payment;
import com.interviewmate.payment.dto.request.PaymentSubscribeRequest;
import com.interviewmate.payment.dto.response.PaymentHistoryResponse;
import com.interviewmate.payment.dto.response.PaymentResponse;
import com.interviewmate.payment.dto.response.PlanResponse;
import com.interviewmate.payment.mapper.PaymentMapper;
import com.interviewmate.subscription.domain.Subscription;
import com.interviewmate.subscription.mapper.SubscriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;

    private final SubscriptionMapper subscriptionMapper;

    public List<PlanResponse> getPlans() {
        return List.of(
                new PlanResponse(
                        "FREE",
                        "Free",
                        0,
                        "일 3회 면접, 기본 분석 제공"
                ),
                new PlanResponse(
                        "BASIC",
                        "Basic",
                        4900,
                        "무제한 텍스트 면접, 히스토리 제공"
                ),
                new PlanResponse(
                        "PRO",
                        "Pro",
                        9900,
                        "음성 면접, 기업별 질문, 상세 리포트 제공"
                )
        );
    }

    public PaymentResponse subscribe(
            Long userId,
            PaymentSubscribeRequest request
    ) {
        int amount = getAmountByPlanType(request.getPlanType());

        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setPlanType(request.getPlanType());
        payment.setAmount(amount);
        payment.setStatus("PAID");

        paymentMapper.insertPayment(payment);

        subscriptionMapper.expireActiveSubscription(userId);

        Subscription subscription = new Subscription();
        subscription.setUserId(userId);
        subscription.setPlanType(request.getPlanType());
        subscription.setStatus("ACTIVE");

        subscriptionMapper.insertSubscription(subscription);

        return new PaymentResponse(
                payment.getPaymentId(),
                payment.getPlanType(),
                payment.getAmount(),
                payment.getStatus()
        );
    }

    public List<PaymentHistoryResponse> getPaymentHistory(
            Long userId
    ) {
        return paymentMapper.findByUserId(userId)
                .stream()
                .map(PaymentHistoryResponse::from)
                .toList();
    }

    private int getAmountByPlanType(String planType) {

        return switch (planType) {
            case "BASIC" -> 4900;
            case "PRO" -> 9900;
            default -> 0;
        };
    }
}