package com.kush.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kush.dao.UserRepository;
import com.kush.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = repo.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + userName));
		
		return new MyUserDetails(user.get());
	}

}
