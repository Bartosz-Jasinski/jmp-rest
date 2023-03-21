package com.epam.repo;

import org.springframework.data.repository.CrudRepository;

import com.epam.model.Subscription;

public interface ServiceRepository extends CrudRepository<Subscription, Long> {
}
