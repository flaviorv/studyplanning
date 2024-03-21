package com.frv.studyplanning.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.frv.studyplanning.model.auxiliary.Constants;

@SpringBootTest
public class WeekTest {
	
	
	
	@Test
	void shold_subtract_the_current_minutes_from_the_start_time() {
		Week wtest = new Week();
		//	startTime
		Integer twoPastMinutes = wtest.getCurrentMinutes() - 2;
		assertEquals(2, wtest.calculateStudyTime(twoPastMinutes));
	}
	
	 @Test
	 void shold_calculate_if_week_is_ended() {
		Week wtest = new Week();
	 	wtest.setStartTime();
	 	wtest.setEnded();
	 	assertFalse(wtest.isEnded());
	 	//it takes 10080 minutes to end the week
	 	wtest.setStartTime(wtest.getCurrentMinutes() - 10080);
	 	wtest.setEnded();
	 	assertTrue(wtest.isEnded());
	 	
	 	wtest.setStartTime(wtest.getCurrentMinutes() - 10079);
	 	wtest.setEnded();
	 	assertFalse(wtest.isEnded());
	 	
	 	wtest.setStartTime(wtest.getCurrentMinutes() - 10081);
	 	wtest.setEnded();
	 	assertTrue(wtest.isEnded());
	 }
	 
	 @Test
	 void shold_calculate_points_and_genetate_feedback( ) {
		 Week wtest = new Week();
		 StudyGoal sg1 = new StudyGoal("Fazer protótipo de telas da Loja de Ração");
		 sg1.setDone();
		 wtest.addGoal(sg1);
		 wtest.addGoal(new StudyGoal("Ler capítulo 1 e 15 de Applying UML and Patterns"));
		 wtest.addGoal(new StudyGoal("Implementar database no Studyplanning"));
		 wtest.setDonePercent(sg1.calculateDonePercent(wtest.getGoals()));
		 System.out.println(wtest.getDonePercent());
		 TimeGoal tgtest = new TimeGoal(3);
		 wtest.setStudyTime(1);
		 wtest.setTimeDonePercent(tgtest.calculateDonePercent(wtest.getStudyTime()));
		 
		 Integer points = wtest.calculatePoints();
		 String feedback = wtest.generateFeedback();
		 
		 assertEquals(points, 3);
		 assertEquals(feedback, Constants.BAD_FEEDBACK);
	 }
}
