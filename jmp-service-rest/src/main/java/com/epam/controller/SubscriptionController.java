package com.epam.controller;

import java.util.List;

import com.epam.model.SubscriptionRequestDto;
import com.epam.model.SubscriptionResponseDto;

public interface SubscriptionController {
	SubscriptionResponseDto createSubscription(SubscriptionRequestDto request);

	SubscriptionResponseDto updateSubscription(SubscriptionRequestDto request);

	void deleteSubscription(Long id);

	SubscriptionResponseDto getSubscription(Long id);

	List<SubscriptionResponseDto> getAllSubscription();
}
