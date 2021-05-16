package com.kush.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kush.dao.LeftStudentRepository;
import com.kush.dao.StudentRepository;
import com.kush.model.LeftStudentData;
import com.kush.model.StudentData;

@Service
public class StudentDataService {
	@Autowired
	StudentRepository repo;
	@Autowired
	LeftStudentRepository leftRepo;
	
	public void update(StudentData studData){
		repo.save(studData);
	}
	
	public int getMaxId(){
		return repo.selectMaxIdStudent();
	}
	
	public int getLeftMaxId(){
		return leftRepo.selectMaxIdStudent();
	}
	
	public void persist(StudentData studData){
		repo.save(studData);
	}
	
	public void persist(LeftStudentData leftStudentData){
		leftRepo.save(leftStudentData);
	}
	
	public List<StudentData> getAllStudents(){
		return (List<StudentData>) repo.findAll();
	}
	
	public StudentData getStudentById(int id){
		return repo.findById(id).get();
	}
	
	public void deleteStudent(StudentData studData){
		repo.delete(studData);
	}
	
	public List<LeftStudentData> getAllLeftStudent(){
		return (List<LeftStudentData>)leftRepo.findAll();
	}
	
	public List<StudentData> getPayList(){
		List<StudentData> studentList = (List<StudentData>)repo.findAll();
		
		return studentList;
	}
	
	public List<StudentData> getNewPayList(int id, Date da){
		List<StudentData> studentList = (List<StudentData>)repo.findAll();
		
		for(StudentData studentData : studentList)
			if(studentData.getId() == id) {
				List<Date> dates = studentData.getPayDates();
				dates.add(da);
				
				repo.save(studentData);
			}
		
		return studentList;
	}
	
	public List<LeftStudentData> getLeftPayList(){
		List<LeftStudentData> studentList = (List<LeftStudentData>)leftRepo.findAll();
		
		return studentList;
	}
}
