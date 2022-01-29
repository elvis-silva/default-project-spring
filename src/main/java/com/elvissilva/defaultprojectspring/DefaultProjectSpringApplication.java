package com.elvissilva.defaultprojectspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DefaultProjectSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(DefaultProjectSpringApplication.class, args);

	}
}
