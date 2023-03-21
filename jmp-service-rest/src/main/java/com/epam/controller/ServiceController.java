package com.epam.controller;

import com.epam.model.SubscriptionRequestDto;
import com.epam.model.SubscriptionResponseDto;

public interface ServiceController {
	SubscriptionResponseDto createSubscription(SubscriptionRequestDto request);

	SubscriptionResponseDto updateSubscription(SubscriptionRequestDto request);

	void deleteSubscription(Long id);

	SubscriptionResponseDto getSubscription(Long id);

	SubscriptionResponseDto getAllSubscription();
}
