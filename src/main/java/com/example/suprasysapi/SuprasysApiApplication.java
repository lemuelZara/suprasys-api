package com.example.suprasysapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.suprasysapi")
public class SuprasysApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SuprasysApiApplication.class, args);
	}

}
