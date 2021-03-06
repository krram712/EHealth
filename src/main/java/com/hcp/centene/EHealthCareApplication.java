package com.hcp.centene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class EHealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(EHealthCareApplication.class, args);
	}

}
