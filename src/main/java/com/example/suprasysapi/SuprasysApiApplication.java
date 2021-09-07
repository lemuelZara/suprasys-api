package com.example.suprasysapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.suprasysapi.domain")
public class SuprasysApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuprasysApiApplication.class, args);
	}

}
