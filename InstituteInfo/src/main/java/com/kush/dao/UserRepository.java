package com.kush.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kush.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
