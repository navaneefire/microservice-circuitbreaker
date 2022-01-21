package com.annachi.circuitbreaker;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CircuitBreakerApplication {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(CircuitBreakerApplication.class, args);
        
        String[] beanNames = ctx.getBeanDefinitionNames();
         
        Arrays.sort(beanNames);
 
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }		
	}
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
