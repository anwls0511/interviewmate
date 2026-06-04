package com.interviewmate.subscription.mapper;

import com.interviewmate.subscription.domain.Subscription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscriptionMapper {

    int insertSubscription(Subscription subscription);

    int expireActiveSubscription(Long userId);
}