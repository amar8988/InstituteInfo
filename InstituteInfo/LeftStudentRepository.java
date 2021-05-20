package com.kush.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kush.model.LeftStudentData;

public interface LeftStudentRepository extends CrudRepository<LeftStudentData, Integer> {
	@Query(value="select id from left_student_data order by id desc limit 1" , nativeQuery=true)
	public int selectMaxIdStudent();
}
