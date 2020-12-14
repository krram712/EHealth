package com.hcp.centene.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcp.centene.model.Customer;
import com.hcp.centene.reposiroty.CustomerRepository;
import com.hcp.centene.service.EnrollService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnrollServiceImp implements EnrollService {
	private static final Logger logger = LoggerFactory.getLogger(EnrollServiceImp.class);

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Mono<Customer> getCustomerByName() {
		logger.info("Enter EnrollServiceImp:getCustomerByName.");
		logger.info("getCustomerByName: " ,  customerRepository.findByName("Raghu"));
		return customerRepository.findByName("Raghu");
	}

	@Override
	public Flux<Customer> getCustomers() {
		logger.info("Enter EnrollServiceImp: getCustomers.");
		logger.info("findAll:" + customerRepository.findAll().switchIfEmpty(Flux.empty()) );
		return customerRepository.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Customer> saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Mono<Void> deleteEnrollById(String id) {
		return customerRepository.deleteById(id);
	}

	@Override
	public Mono<Customer> getCustomerById(String id) {
		return customerRepository.findById(id);
	}

	@Override
	public Mono<Customer> updateEnroll(Customer customer) {
		return customerRepository.save(customer);
	}

}
