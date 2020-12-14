package com.hcp.centene.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcp.centene.common.vo.ServiceResponse;
import com.hcp.centene.model.Customer;
import com.hcp.centene.service.EnrollService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/enroll")
public class EnrollController {
	private static final Logger logger = LoggerFactory.getLogger(EnrollController.class);
	
	@Autowired
	EnrollService enrollService; 
	
	@GetMapping()
	public ResponseEntity<Flux<Customer>> Q(){
		logger.info("findAll Enrolls.");
		return ResponseEntity.ok(enrollService.getCustomers());
	}
	
	@GetMapping("/name")
	public ResponseEntity<Mono<Customer>> getCustomerByName(){
		logger.info("Enter getCustomer");
		return ResponseEntity.ok(enrollService.getCustomerByName());
	}
	
	
	@PostMapping()
	public Mono<ResponseEntity<ServiceResponse<Customer>>> save(@RequestBody Customer customer) {
		logger.info("Will register the student :: "+ customer.getId() + " :: " + customer.getName());
	 return buildResponse(enrollService.saveCustomer(customer));
	}
	
	@PutMapping()
	public ResponseEntity<Mono<Customer>> update(@RequestBody final Customer customer){
		Mono<Customer> c = enrollService.getCustomerById(customer.getId());
		HttpStatus status = c.equals(Mono.empty())?HttpStatus.NOT_FOUND:HttpStatus.OK;
		if(c.equals(Mono.empty())){
			return new ResponseEntity<Mono<Customer>>(Mono.empty(),status);
		}
		return new ResponseEntity<Mono<Customer>>(enrollService.updateEnroll(customer),status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mono<Void>> delete(@PathVariable String id){
		Mono<Customer> c = enrollService.getCustomerById(id);
		HttpStatus status = c.equals(Mono.empty())?HttpStatus.NOT_FOUND:HttpStatus.OK;
		if(c.equals(Mono.empty())){
			return new ResponseEntity<Mono<Void>>(Mono.empty(),status);
		}
		return new ResponseEntity<Mono<Void>>(enrollService.deleteEnrollById(id),status);
	}
	
	private <T> Mono<ResponseEntity<ServiceResponse<T>>>  buildResponse(Mono<T> responseMono){
		ServiceResponse<T> serviceResponse = new ServiceResponse<T>();
		HttpStatus status = responseMono.equals(Mono.empty())?HttpStatus.NOT_FOUND:HttpStatus.OK;
		return Mono.just(new ResponseEntity<>(serviceResponse,status));
	}

}
