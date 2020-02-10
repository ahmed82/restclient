package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;
import com.example.demo.model.RestResponse;

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
		
		@GetMapping("/em-entity")
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
		
		
		@GetMapping("/em-obj")
		public List<Employee> callServiceForObject() {
			
			RestTemplate restTemplate = new RestTemplate();
			List<Employee> empList = new ArrayList<>(); 
			String ResourceUrl = "http://localhost:8081/employees";
			Employee[] apiResponse  = restTemplate.getForObject(ResourceUrl , Employee[].class);
			
				 empList = Arrays.asList(apiResponse);
			
			System.out.println("3333333333333333333333333333333333333333333");
			for(int i = 0; i< apiResponse.length ; i++){

				System.out.println(apiResponse[i]);

				}
			
			for (Employee strTemp : apiResponse){
				System.out.println("for type a : Array");
				System.out.println(strTemp);

				}
			for(int i = 0; i< empList.size() ; i++){
				System.out.println("arraylist");
				System.out.println(empList.get(i));

				}
			//System.out.println(empList.toString());
			Arrays.stream(apiResponse) 
            .forEach(e->System.out.print(" # STREAM %%%%%%%% "+e + " ")); 
			return empList;
		}
}
