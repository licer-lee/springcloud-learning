package com.licerlee.eurekaconfigserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class EurekaConfigServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConfigServerApplication.class).web(true).run(args);
	}
}
