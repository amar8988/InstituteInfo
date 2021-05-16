package com.kush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.kush.dao")
@SpringBootApplication
public class InstituteInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstituteInfoApplication.class, args);
	}
}
