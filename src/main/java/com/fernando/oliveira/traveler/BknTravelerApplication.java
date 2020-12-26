package com.fernando.oliveira.traveler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BknTravelerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BknTravelerApplication.class, args);
	}

}
