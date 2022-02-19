package com.kush;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kush.service.HomeCall;

@EnableJpaRepositories(basePackages="com.kush.dao")
@SpringBootApplication
public class InstituteInfoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(InstituteInfoApplication.class)
				.headless(false)
				.run(args);
		
		//SpringApplication.run(InstituteInfoApplication.class, args);
		
		HomeCall.fun();
	}
	
	/*@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}*/
}