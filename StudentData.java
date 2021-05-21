package com.kush.model;

/*import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;*/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;

@Entity
public class StudentData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String studentName;
	private String batch;
	private String course;
	private String fatherName;
	private String contactNumber;
	private String joiningDate;
	private String startingDate;
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name="stud_pay_date",joinColumns=@JoinColumn(name=
	 * "student_id"))
	 * 
	 * @Column(name="pay_date") List<Date> payDates;
	 */
	
	public StudentData() {	}
	
	public StudentData(LeftStudentData leftStudentData) {
		this.studentName = leftStudentData.getStudentName();
		this.batch = leftStudentData.getBatch();
		this.course = leftStudentData.getCourse();
		this.fatherName = leftStudentData.getFatherName();
		this.contactNumber = leftStudentData.getContactNumber();
		this.joiningDate = leftStudentData.getJoiningDate();
		this.startingDate = leftStudentData.getStartingDate();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}
	
	/*
	 * public List<Date> getPayDates() { return payDates; }
	 * 
	 * public void setPayDates(List<Date> payDates) { this.payDates = payDates; }
	 */
	
	@Override
	public String toString() {
		return "StudentData [id=" + id + ", studentName=" + studentName + ", batch=" + batch + ", course=" + course
				+ ", fatherName=" + fatherName + ", contactNumber=" + contactNumber + ", joiningDate=" + joiningDate
				+ ", startingDate=" + startingDate + "]";
	}
	
}
