package com.frv.studyplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.Student;
import com.frv.studyplanning.model.service.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String intialPage() {
		return "InitialPage";
	}
	
	@PostMapping("/authenticate")
	public Student authenticateStudent(@RequestBody Student student) {
		return studentService.authenticate(student);
	}
	
	@PostMapping("/register")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
}
