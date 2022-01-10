package com.kush.coaching.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kush.coaching.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	List<User> findByUserName(String userName);
}
