package com.epam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Subscription {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private User user;
	@Column
	private LocalDate startDate;
}
