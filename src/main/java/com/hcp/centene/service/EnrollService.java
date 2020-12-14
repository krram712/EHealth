package com.hcp.centene.service;

import com.hcp.centene.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnrollService {
	Mono<Customer> getCustomerByName();
	Mono<Customer> getCustomerById(String id);
	Flux<Customer> getCustomers();
	Mono<Customer> saveCustomer(Customer customer);
	Mono<Customer> updateEnroll(Customer customer);
	Mono<Void> deleteEnrollById(String id);
}
