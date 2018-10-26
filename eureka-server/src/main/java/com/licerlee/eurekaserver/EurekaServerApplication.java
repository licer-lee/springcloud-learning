package com.licerlee.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 一个简单的服务发现注册中心
 * @author liwc
 * @date 2018年10月26日 下午12:19:48
 * @ EurekaServerApplication
 */
@EnableEurekaServer
// @EnableEurekaClient
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		// SpringApplication.run(EurekaServerApplication.class, args);
		new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
	}
}
