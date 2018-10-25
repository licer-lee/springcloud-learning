package com.licerlee.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
	}

	@Value("${info.profile}") // git配置文件里的key
	String profile;
	
	@Value("${info.from}") // git配置文件里的key
	String from;

	@RequestMapping(value = "/profile")
	public String profile() {
		return profile;
	}
	
	@RequestMapping(value = "/from")
	public String from() {
		return from;
	}
}
