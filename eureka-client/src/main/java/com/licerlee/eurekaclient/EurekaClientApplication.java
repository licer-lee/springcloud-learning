package com.licerlee.eurekaclient;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		// SpringApplication.run(EurekaClientApplication.class, args);
		new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
	}

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/dc")
	public String dc() throws InterruptedException {
		// 模拟请求超时
//		TimeUnit.SECONDS.sleep(5);
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
