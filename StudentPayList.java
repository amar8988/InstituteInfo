package com.kush.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class StudentPayList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int studentId;
	private String studentName;
	@ElementCollection
	@CollectionTable(name="stud_pay_list",joinColumns=@JoinColumn(name=
	  "student_id"))
	@Column(name="student_date")
	private List<Date> payDates;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public List<Date> getPayDates() {
		return payDates;
	}
	
	public void setPayDates(List<Date> payDates) {
		this.payDates = payDates;
	}
	
	@Override
	public String toString() {
		return "StudentPayList [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName + ", payDates="
				+ payDates + "]";
	}
}
