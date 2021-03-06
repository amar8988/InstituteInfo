package com.kush.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kush.model.LeftStudentData;
import com.kush.model.StudentData;
import com.kush.model.StudentPayList;
import com.kush.service.StudentDataService;

@Controller
public class HomeController {
	@Autowired
	StudentDataService studService;
	ModelAndView mav = new ModelAndView("home");
	
	@GetMapping("/login")
	public ModelAndView welcome() {
		List<StudentData> studList = studService.getAllStudents();
		mav.addObject("studList", studList);
		
		return mav;
	}
	
	@PostMapping("/register")
	public String doRegister(Model model) {
		model.addAttribute("studentData", new StudentData());
		
		return "register";
	}
	
	@PostMapping("/registration")
	public String doAddition(@ModelAttribute StudentData studentData , Model model){
		studService.persist(studentData);
		List<StudentData> studList = studService.getAllStudents();
		model.addAttribute("studList", studList);
		
		return "home";
	}
	
	@PostMapping("/edit")
	public String startEdit(Model model) {
		StudentData studentData = new StudentData();
		model.addAttribute("studentData" , studentData);
		
		return "edition";
	}
	
	@PostMapping("/modify")
	public String doModification(@ModelAttribute StudentData studentData , Model model){
		studentData = studService.getStudentById(studentData.getId());
		model.addAttribute("studentData", studentData);
		
		return "edit";
	}
	
	@PostMapping("/editing")
	public String doEdit(@ModelAttribute StudentData studData , Model model){
		studService.update(studData);
		model.addAttribute("studList" , studService.getAllStudents());
		
		return "home";
	}
	
	@PostMapping("/remove")
	public String removeStudent(Model model) {
		LeftStudentData leftStudentData = new LeftStudentData();
		model.addAttribute("leftStudentData" , leftStudentData);
		
		return "remove";
	}
	
	@PostMapping("/delete")
	public String doDelete(@ModelAttribute LeftStudentData leftStudentData , Model model ){
		StudentData studentData = studService.getStudentById(leftStudentData.getId());
		leftStudentData.setStudentName(studentData.getStudentName());
		leftStudentData.setJoiningDate(studentData.getJoiningDate());
		leftStudentData.setStartingDate(studentData.getStartingDate());
		leftStudentData.setBatch(studentData.getBatch());
		leftStudentData.setCourse(studentData.getCourse());
		leftStudentData.setFatherName(studentData.getFatherName());
		leftStudentData.setContactNumber(studentData.getContactNumber());
		
		studService.deleteStudent(studentData);
		studService.persist(leftStudentData);
		
		List<StudentData> studList = studService.getAllStudents();
		model.addAttribute("studList", studList);
		
		return "home";
	}
	
	@GetMapping("/left")
	public String displayLeftStudent(Model model){
		List<LeftStudentData> allLeftStudent = studService.getAllLeftStudent();
		model.addAttribute("studList" , allLeftStudent);
		model.addAttribute("leftStudentData", new LeftStudentData());
		
		return "leftDetail";
	}
	
	@GetMapping("/payList")
	public String getPayDates(Model model) {
		List<StudentPayList> studentPayList = studService.getStudentPayments();
		model.addAttribute("payList", studentPayList);
		
		return "payments";
	}
	
	@GetMapping("/payMore/{id}")
	public String payMore(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		//model.addAttribute("payDate", new Date());
		
		return "payMore";
	}
	
	@PostMapping("/afterPayMore")
	public String getPayList(@ModelAttribute("date") Date date, @ModelAttribute StudentData studentData, Model model) {
		List<StudentData> studentList = studService.getNewPayList(studentData.getId(), date);
		model.addAttribute("studentList", studentList);
		
		return "payDateView";
	}
	
	@GetMapping("/leftPayDates")
	public String getLeftPayDates(Model model) {
		List<StudentPayList> studentList = studService.getLeftPayList();
		model.addAttribute("studentList", studentList);
		
		return "leftPayDateView";
	}
	
	@GetMapping("/reJoining/{id}")
	public String studentReJoining(@PathVariable int id , Model model) {
		StudentData studentData = new StudentData(studService.getLeftStudentById(id));		//using parameter as LeftStudentData
		
		model.addAttribute("studentData", studentData);
		
		return "reJoin";
	}
	
	@PostMapping("/addPayment")
	public ModelAndView addPayment(@RequestParam Integer id, @ModelAttribute Date payDate, Model model) {
		//studService.addPayDate(id, payDate);
		System.out.println(payDate);
		List<StudentData> studList = studService.getAllStudents();
		mav.addObject("studList", studList);
		
		return mav;
	}
}