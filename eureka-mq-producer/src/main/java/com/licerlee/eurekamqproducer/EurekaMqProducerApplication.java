package com.licerlee.eurekamqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaMqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMqProducerApplication.class, args);
	}
}
