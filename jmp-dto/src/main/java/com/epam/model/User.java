package com.epam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "jmp-user")
@NoArgsConstructor
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

	public User(Long id, String name, String surname, LocalDate birthday) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}
}
