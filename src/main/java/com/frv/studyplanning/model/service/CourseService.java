package com.frv.studyplanning.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.frv.studyplanning.model.domain.Course;
import com.frv.studyplanning.model.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> allCourses(Integer idStudent ){
		return courseRepository.getAllCourses(idStudent);
	}
	
	public Course getCourse(Integer course) {
		return courseRepository.getCourse(course);
	}
	
	public Course saveCourse(Course course) {
		course.setStartDay();
		course.setLastDay();
		return courseRepository.save(course);
	}
}
