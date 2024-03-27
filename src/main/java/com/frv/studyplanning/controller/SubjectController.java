package com.frv.studyplanning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.Course;
import com.frv.studyplanning.model.domain.Subject;
import com.frv.studyplanning.model.service.SubjectService;

@RestController
@CrossOrigin("*")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/savesubject")
	public Subject saveSubject(@RequestBody Subject subject) {
		return subjectService.saveSubject(subject);
	}
	
	@PostMapping("/subjects")
	public List<Subject> getAllSubjects(@RequestBody Course course) {
		return subjectService.getAllSubjects(course.getId());
	}
	

	public Subject getSubjectPerId(@RequestBody Subject subject) {
		return subjectService.getSubjectPerId(subject.getId());
	}
	
}
