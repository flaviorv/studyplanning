package com.frv.studyplanning.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.frv.studyplanning.model.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query("from Course c where c.student.id = :idStudent")
	List<Course> getAllCourses(Integer idStudent);
}
