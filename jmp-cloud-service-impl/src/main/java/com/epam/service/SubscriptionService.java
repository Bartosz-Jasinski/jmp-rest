package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.controller.SubscriptionController;
import com.epam.model.SubscriptionRequestDto;
import com.epam.model.SubscriptionResponseDto;

@Service
@RestController
@RequestMapping("subscriptions")
public class SubscriptionService {
	private final SubscriptionController subscriptionController;

	@Autowired
	public SubscriptionService(SubscriptionController subscriptionController) {
		this.subscriptionController = subscriptionController;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto request) {
		return subscriptionController.createSubscription(request);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto request) {
		return subscriptionController.updateSubscription(request);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteSubscription(@PathVariable("id") Long id) {
		subscriptionController.deleteSubscription(id);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public SubscriptionResponseDto getSubscription(@PathVariable("id") Long id) {
		return subscriptionController.getSubscription(id);
	}

	@GetMapping(produces = "application/json")
	public List<SubscriptionResponseDto> getAllSubscription() {
		return subscriptionController.getAllSubscription();
	}
}
