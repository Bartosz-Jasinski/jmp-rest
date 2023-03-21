package com.epam.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.model.Subscription;
import com.epam.model.SubscriptionResponseDto;

@Component
public class SubscriptionToSubscriptionResponseConverter implements Converter<Subscription, SubscriptionResponseDto> {

	@Override
	public SubscriptionResponseDto convert(Subscription source) {
		return new SubscriptionResponseDto(source.getId(),
				source.getUser().getId(),
				source.getStartDate().toString());
	}
}
