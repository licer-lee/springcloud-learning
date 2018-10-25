package com.licerlee.eurekaconfigclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConfigClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConfigClientApplication.class).web(true).run(args);
	}
}
