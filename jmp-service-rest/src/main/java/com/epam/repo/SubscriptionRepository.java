package com.epam.repo;

import org.springframework.data.repository.CrudRepository;

import com.epam.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
