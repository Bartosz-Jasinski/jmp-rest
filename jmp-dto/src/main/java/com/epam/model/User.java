package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
	private Long id;
	private String name;
	private String surname;
	private LocalDate birthday;
}
