package com.epam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "jmp-user")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private LocalDate birthday;
	@OneToMany(mappedBy = "user")
	private Set<Subscription> subscriptions;
}
