package com.hcp.centene.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "customer")
public class Customer {

	@Id
	private String id;
	private String name;
	private boolean status;
	private String birthDate;
	private int phoneNumber;
	private Dependents dependents;
	
}
