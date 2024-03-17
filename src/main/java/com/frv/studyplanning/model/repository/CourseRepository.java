package com.frv.studyplanning.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frv.studyplanning.model.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query("from Course c where c.student.id = :idStudent")
	List<Course> getAllCourses(Integer idStudent);
	
	@Query("from Course c where c.id = :idCourse")
	Course getCourse(Integer idCourse);
}
