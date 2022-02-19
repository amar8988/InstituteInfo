package com.kush.service;

import org.springframework.web.client.RestTemplate;

import com.kush.model.User;

public class HomeCall {
	public static void fun() {
		new RestTemplate().getForObject("http://localhost:8081/login", User.class);
	}
}
