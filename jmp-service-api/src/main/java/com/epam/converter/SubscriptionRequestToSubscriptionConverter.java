package com.epam.converter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.model.Subscription;
import com.epam.model.SubscriptionRequestDto;
import com.epam.repo.UserRepository;

@Component
public class SubscriptionRequestToSubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {
	private final UserRepository userRepository;

	@Autowired
	public SubscriptionRequestToSubscriptionConverter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Subscription convert(SubscriptionRequestDto source) {
		return userRepository.findById(source.getUserId())
				.map(user -> new Subscription(source.getId(),
						user,
						LocalDate.now()))
				.orElseThrow(() -> new RuntimeException("Error while fetching User"));
	}
}
