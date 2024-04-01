package com.frv.studyplanning.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.service.WeekService;

@RestController
@CrossOrigin("*")
public class StudyTimeController {
	@Autowired
	private WeekService weekService;
	
	@PutMapping("/startsessiontime")
	public Week setSessionTime(@RequestBody Week week) {
		Week _week = weekService.getWeekById(week.getId());
		Integer current = week.getCurrentMinutes();
		_week.setStartSessionTime(current); 
		return weekService.saveWeek(_week);
	}
	
	@PutMapping("/calculatestudytime")
	public Week calculateStudyTime(@RequestBody Week week) {
		week.calculateStudyTime(week.getStartSessionTime());
		return weekService.saveWeek(week);
	}
}
