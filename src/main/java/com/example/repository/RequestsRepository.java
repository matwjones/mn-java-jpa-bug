package com.example.repository;

import com.example.model.RegistrationRequest;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.reactive.RxJavaCrudRepository;

@Repository
public interface RequestsRepository extends CrudRepository<RegistrationRequest, Long> {
	boolean existsByKey(String key);
}
