package com.frv.studyplanning.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.frv.studyplanning.model.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Query("from Student s where s.email = :email and s.password = :password")
	Student authenticate(String email, String password);
}
