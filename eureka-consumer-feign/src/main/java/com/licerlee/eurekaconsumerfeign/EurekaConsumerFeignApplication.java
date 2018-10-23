package com.licerlee.eurekaconsumerfeign;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@EnableDiscoveryClient注解用来将当前应用加入到服务治理体系中。
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EurekaConsumerFeignApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerFeignApplication.class).web(true).run(args);
	}
}
