package com.epam.repo;

import org.springframework.data.repository.CrudRepository;

import com.epam.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
