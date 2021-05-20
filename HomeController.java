package com.kush.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/")
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
		
		return "leftDetail";
	}
	
	@GetMapping("/payDates")
	public String getPayDates(Model m) {
		List<StudentPayList> studentPayList = studService.getPayList();
		//List<StudentPayList> studentPayList = studService.
		m.addAttribute("studentPayList", studentPayList);
		
		return "payDateView";
	}
	
	@GetMapping("/pay")
	public String payMore(@RequestParam Integer id, Model m) {
		m.addAttribute("date", new Date());
		StudentData studentData = new StudentData();
		studentData.setId(id);
		m.addAttribute("studentData", studentData);
		
		return "payDateMore";
	}
	
	@PostMapping("/afterPayMore")
	public String getPayList(@ModelAttribute("date") Date da, @ModelAttribute StudentData studentData, Model m) {
		List<StudentData> studentList = studService.getNewPayList(studentData.getId(), da);
		m.addAttribute("studentList", studentList);
		
		return "payDateView";
	}
	
	@GetMapping("/leftPayDates")
	public String getLeftPayDates(Model m) {
		List<LeftStudentData> studentList = studService.getLeftPayList();
		m.addAttribute("studentList", studentList);
		
		return "leftPayDateView";
	}
}
