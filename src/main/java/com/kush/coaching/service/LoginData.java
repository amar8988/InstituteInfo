package com.kush.coaching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kush.coaching.entity.User;
import com.kush.coaching.repository.UserRepository;

@Service
public class LoginData {
	@Autowired
	 UserRepository userRepository;
	
	public String meth(String userName) {
		String pwd="";
		
		for(User user : userRepository.findByUserName(userName))
			pwd = user.getPassword();
			
		return pwd;
	}
}
