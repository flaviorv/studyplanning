package com.frv.studyplanning.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.repository.WeekRepository;

@Service
public class WeekService {
	@Autowired
	private WeekRepository weekRepository;
	
	public List<Week> getAllWeeks(Integer subjectId){
		return weekRepository.getAllWeeks(subjectId);
	}
	
	public Week saveWeek(Week week) {
		return weekRepository.save(week);
	}
	
	public Week updateWeek(Week week) {
		weekRepository.findById(week.getId());
		return weekRepository.save(week);
	}
}
