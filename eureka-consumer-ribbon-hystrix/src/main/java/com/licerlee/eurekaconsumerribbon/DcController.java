package com.licerlee.eurekaconsumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DcController {

	@Autowired
	ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc() {
		return consumerService.consumer();
	}

	// 消费者服务类
	@Component
	class ConsumerService {

		@Autowired
		RestTemplate restTemplate;

		@HystrixCommand(fallbackMethod = "fallback")
		public String consumer() {
			return restTemplate.getForObject("http://eureka-client/dc", String.class);
		}

		public String fallback() {
			return "fallback! The network slow, please wait a moment...";
		}

	}
}
