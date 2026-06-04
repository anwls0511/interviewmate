package com.interviewmate.subscription.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Subscription {

    private Long subscriptionId;

    private Long userId;

    private String planType;

    private String status;

    private LocalDateTime startedAt;

    private LocalDateTime expiredAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}