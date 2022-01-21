package com.annachi.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class FallbackController 
{
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/items")
	@CircuitBreaker(name="USERSERVICE",fallbackMethod = "itemsNotAvailable")
	 public String getItems()
	 {
		return restTemplate.getForObject("https://localhost:9002/user/6", String.class);		  
	 }
	 public String itemsNotAvailable(Exception e)
	 {
		 return "items are not ready";
	 }
}
