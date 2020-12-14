package com.hcp.centene.reposiroty;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hcp.centene.model.Customer;

import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
	Mono<Customer> findByName(String name);
}
