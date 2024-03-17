package com.frv.studyplanning.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.frv.studyplanning.model.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer > {
	@Query("from Subject su where su.course.id = :idCourse")
	List<Subject> getAllSubjects(Integer idCourse);
	
	

}
