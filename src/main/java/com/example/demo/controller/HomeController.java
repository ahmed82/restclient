package com.example.demo.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

		@GetMapping("/hello")
		public String home() {
			return "Spring Boot Rest respond";
		}
		
	/*
	 * @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 */
		
		@GetMapping("/ss")
		public ResponseEntity<String> callService() {
			
			RestTemplate restTemplate = new RestTemplate();
			String ResourceUrl = "http://localhost:8081/employees";
			ResponseEntity<String> response  = restTemplate.getForEntity(ResourceUrl , String.class);
			// assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
			System.out.println("**1**"+response.getHeaders().toString());
			System.out.println("**1**"+response);
			System.out.println("**2**"+response.getBody().toString());
			System.out.println("**3**"+response.getStatusCodeValue());
			System.out.println("**3**"+response.getStatusCode());
			return response;
		}
}
