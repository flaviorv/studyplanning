package com.frv.studyplanning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.Subject;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.service.WeekService;

@RestController
@CrossOrigin("*")
public class WeekController {
	@Autowired
	private WeekService weekService;
	
	@PostMapping("/weeks")
	public List<Week> getAllWeeks(@RequestBody Subject subject){
		return  weekService.getAllWeeks(subject.getId());
	}
	
	@PutMapping("/updateweek")
	public Week updateWeek(@RequestBody Week week) {
		return weekService.updateWeek(week);
	}
	
	@PostMapping("/saveweek")
	public Week saveWeek(@RequestBody Week week) {
		week.setStartTime();
		return weekService.saveWeek(week);
	}
}
