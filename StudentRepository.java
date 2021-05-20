package com.kush.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kush.model.StudentData;

public interface StudentRepository extends CrudRepository<StudentData, Integer> {
	Optional<StudentData> findById(int id);
	
	@Query(value="select id from student_data order by id desc limit 1" , nativeQuery=true)
	public int selectMaxIdStudent();
}
