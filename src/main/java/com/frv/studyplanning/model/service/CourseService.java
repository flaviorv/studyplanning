package com.frv.studyplanning.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
}
