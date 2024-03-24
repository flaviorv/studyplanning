package com.frv.studyplanning.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frv.studyplanning.model.domain.StudyGoal;

@Repository
public interface StudyGoalRepository extends JpaRepository<StudyGoal, Integer>{
	@Query("from StudyGoal sg where sg.week.id = :weekId")
	List<StudyGoal> getStudyGoalsPerWeek(Integer weekId);
	
	@Query("from StudyGoal sg where sg.id = :studyGoalId")
	StudyGoal getStudyGoalPerId(Integer studyGoalId);
}
