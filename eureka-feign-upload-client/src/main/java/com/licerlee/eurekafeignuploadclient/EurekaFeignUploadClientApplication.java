package com.licerlee.eurekafeignuploadclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EurekaFeignUploadClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaFeignUploadClientApplication.class).web(true).run(args);
	}

	
	@FeignClient(value = "eureka-feign-upload-server", configuration = UploadService.MultipartSupportConfig.class)
	public interface UploadService {

		@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

		@Configuration
		class MultipartSupportConfig {
			@Bean
			public Encoder feignFormEncoder() {
				return new SpringFormEncoder();
			}
		}

	}
}
