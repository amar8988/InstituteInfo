package com.kush.model;

/*import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;*/
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
//import javax.persistence.JoinColumn;

@Entity
public class LeftStudentData {
	@Id
	private int id;
	private String studentName;
	private String batch;
	private String course;
	private String fatherName;
	private String contactNumber;
	private String joiningDate;
	private String startingDate;
	private String lastDate;
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name="stud_pay_date",joinColumns=@JoinColumn(name=
	 * "student_id"))
	 * 
	 * @Column(name="pay_date") List<Date> payDates;
	 */
	
	public String getLastDate() {
		return lastDate;
	}
	
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
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
		return "LeftStudentData [id=" + id + ", studentName=" + studentName + ", batch=" + batch + ", course=" + course
				+ ", fatherName=" + fatherName + ", contactNumber=" + contactNumber + ", joiningDate=" + joiningDate
				+ ", startingDate=" + startingDate + ", lastDate=" + lastDate + "]";
	}
}
