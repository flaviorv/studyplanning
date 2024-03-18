package com.frv.studyplanning.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.frv.studyplanning.model.domain.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week, Integer>{
	@Query("from Week w where w.subject.id = :idSubject")
	List<Week> getAllWeeks(Integer idSubject);
}
