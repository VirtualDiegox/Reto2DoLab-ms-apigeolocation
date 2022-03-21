package com.reto2.microservices.apigeolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApigeolocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigeolocationApplication.class, args);
	}

}
