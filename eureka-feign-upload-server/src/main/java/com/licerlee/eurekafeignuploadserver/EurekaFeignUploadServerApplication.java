package com.licerlee.eurekafeignuploadserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EurekaFeignUploadServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaFeignUploadServerApplication.class).web(true).run(args);
	}

	@RestController
	public class UploadController {

		@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
			System.out.println(file.getName());
			return file.getName();
		}
	}

}
