package com.satyam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.satyam.dao")
@SpringBootApplication
public class HPsatyamLpgApplication {
	public static void main(String[] args) {
		SpringApplication.run(HPsatyamLpgApplication.class, args);
	}
}
