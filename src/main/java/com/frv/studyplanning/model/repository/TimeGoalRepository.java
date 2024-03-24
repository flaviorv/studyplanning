package com.frv.studyplanning.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frv.studyplanning.model.domain.TimeGoal;

@Repository
public interface TimeGoalRepository extends JpaRepository<TimeGoal, Integer> {
	@Query("from TimeGoal tg where tg.week.id = :weekId")
	TimeGoal getTimeGoalsPerWeek(Integer weekId);
}
