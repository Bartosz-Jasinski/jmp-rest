package com.epam.model;

import lombok.Data;

@Data
public class SubscriptionResponseDto {
	private Long id;
	private Long userId;
	private String startDate;
}
