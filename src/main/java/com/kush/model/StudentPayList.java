package com.kush.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class StudentPayList {
	@Id
	private int studId;
	private String studName;
	@ElementCollection
	@CollectionTable(name="stud_pay_list",joinColumns=@JoinColumn(name=
	  "stud_id"))
	@Column(name="pay_date")
	private List<Date> payDates;
	
	public StudentPayList() { }
	
	public StudentPayList(StudentData studentData) {
		this.studId = studentData.getId();
		this.studName = studentData.getStudentName();
	}
	
	public int getStudId() {
		return studId;
	}
	
	public void setStudId(int studId) {
		this.studId = studId;
	}
	
	public String getStudName() {
		return studName;
	}
	
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public List<Date> getPayDates() {
		return payDates;
	}

	public void setPayDates(List<Date> payDates) {
		this.payDates = payDates;
	}

	@Override
	public String toString() {
		return "StudentPayList [studId=" + studId + ", studName=" + studName + ", payDates=" + payDates + "]";
	}
}