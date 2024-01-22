package com.frv.studyplanning.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class StudentController {
	
	@GetMapping("/")
	public String inicio() {
		
		return "TestePáginaEstudante";
	}
}
