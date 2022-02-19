package com.kush.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kush.model.StudentPayList;

public interface StudentPayRepository extends CrudRepository<StudentPayList, Integer> {
	@Query(value="select pay_date from stud_pay_list s where s.stud_id=:id" , nativeQuery=true)
	Optional<List<Date>> getPayListById(@Param("id") int id);
}