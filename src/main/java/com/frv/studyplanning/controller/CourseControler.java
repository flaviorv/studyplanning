package com.frv.studyplanning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.Course;
import com.frv.studyplanning.model.domain.Student;
import com.frv.studyplanning.model.service.CourseService;

@RestController
@CrossOrigin("*")
public class CourseControler {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/courses")
	public List<Course> getAllCourses(@RequestBody Student student) {
		return courseService.allCourses(student.getId());
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable("id") String courseId ) {
		Integer _courseId = Integer.parseInt(courseId);
		return courseService.getCourse(_courseId);
	}
	
	@PostMapping("/savecourse")
	public Course saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@PutMapping("/updatecourse")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
}
