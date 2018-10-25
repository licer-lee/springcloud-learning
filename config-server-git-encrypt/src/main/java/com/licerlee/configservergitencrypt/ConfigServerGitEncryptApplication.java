package com.licerlee.configservergitencrypt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerGitEncryptApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServerGitEncryptApplication.class).web(true).run(args);
	}
}
