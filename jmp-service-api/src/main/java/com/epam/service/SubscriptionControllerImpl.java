package com.epam.service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.epam.controller.SubscriptionController;
import com.epam.model.Subscription;
import com.epam.model.SubscriptionRequestDto;
import com.epam.model.SubscriptionResponseDto;
import com.epam.repo.SubscriptionRepository;

@Service
public class SubscriptionControllerImpl implements SubscriptionController {

	private final SubscriptionRepository subscriptionRepository;
	private final ConversionService conversionService;

	@Autowired
	public SubscriptionControllerImpl(SubscriptionRepository subscriptionRepository, ConversionService conversionService) {
		this.subscriptionRepository = subscriptionRepository;
		this.conversionService = conversionService;
	}

	@Override
	public SubscriptionResponseDto createSubscription(SubscriptionRequestDto request) {
		return Optional.ofNullable(conversionService.convert(request, Subscription.class))
				.filter(subscription -> Objects.isNull(subscription.getId()))
				.map(subscriptionRepository::save)
				.map(subscription -> conversionService.convert(subscription, SubscriptionResponseDto.class))
				.orElseThrow(() -> new RuntimeException("Error during creating Service."));
	}

	@Override
	public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto request) {
		return Optional.ofNullable(conversionService.convert(request, Subscription.class))
				.filter(subscription -> !Objects.isNull(subscription.getId()))
				.map(subscriptionRepository::save)
				.map(subscription -> conversionService.convert(subscription, SubscriptionResponseDto.class))
				.orElseThrow(() -> new RuntimeException("Error during updating Service."));
	}

	@Override
	public void deleteSubscription(Long id) {
		subscriptionRepository.deleteById(id);
	}

	@Override
	public SubscriptionResponseDto getSubscription(Long id) {
		return subscriptionRepository.findById(id)
				.map(subscription -> conversionService.convert(subscription, SubscriptionResponseDto.class))
				.orElseThrow(() -> new InvalidParameterException("Service with id " + id + " not found."));
	}

	@Override
	public List<SubscriptionResponseDto> getAllSubscription() {
		return StreamSupport.stream(subscriptionRepository.findAll().spliterator(), false)
				.map(subscription -> conversionService.convert(subscription, SubscriptionResponseDto.class))
				.toList();
	}
}
