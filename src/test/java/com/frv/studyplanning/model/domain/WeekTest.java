package com.frv.studyplanning.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
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
		 StudyGoal sg2 = new StudyGoal("Ler capítulo 1 e 15 de Applying UML and Patterns");
		 StudyGoal sg3 = new StudyGoal("Implementar database no Studyplanning");
		 StudyGoal sg4 = new StudyGoal("Entregar AT do Projeto de Bloco");
		 sg1.setDone(true);
		 sg2.setDone(true);
		 sg3.setDone(true);
		 sg4.setDone(true);
		 List<StudyGoal> sglist = Arrays.asList(sg1,sg2,sg3);
		 
		 Float goalsPercent = new StudyGoal().calculateDonePercent(sglist);
		 
		 TimeGoal tgtest = new TimeGoal(3);
		 wtest.setStudyTime(2);
		
		 Float timePercent = tgtest.calculateDonePercent(wtest.getStudyTime());
		 
		 Integer points = wtest.calculatePoints(timePercent, goalsPercent) ;
		 String feedback = wtest.generateFeedback(points);
		 
		 assertEquals(points, 8);
		 assertEquals(feedback, Constants.GOOD_FEEDBACK);
		 
	 }
	 
	 @Test
	 void shold_calculate_points_and_genetate_feedback_with_division_by_0( ) {
		 
		 Week wtest = new Week();
		 
		 List<StudyGoal> sglist = Arrays.asList();
		 
		 Float goalsPercent = new StudyGoal().calculateDonePercent(sglist);
		 
		 TimeGoal tgtest = new TimeGoal(3);
		 wtest.setStudyTime(0);
		
		 Float timePercent = tgtest.calculateDonePercent(wtest.getStudyTime());
		 
		 Integer points = wtest.calculatePoints(timePercent, goalsPercent) ;
		 String feedback = wtest.generateFeedback(points);
		 
		 assertEquals(points, 0);
		 assertEquals(feedback, Constants.BAD_FEEDBACK);
		 
	 }
	 
	 @Test
	 void shold_calculate_points_with_more_than_100_percent_study_time( ) {
		 
		 Week wtest = new Week();
		 StudyGoal sg1 = new StudyGoal("Fazer protótipo de telas da Loja de Ração");
		 StudyGoal sg2 = new StudyGoal("Ler capítulo 1 e 15 de Applying UML and Patterns");
		 StudyGoal sg3 = new StudyGoal("Implementar database no Studyplanning");
		 sg1.setDone(true);
		 
		 List<StudyGoal> sglist = Arrays.asList(sg1, sg2, sg3);
		 
		 Float goalsPercent = new StudyGoal().calculateDonePercent(sglist);
		 
		 TimeGoal tgtest = new TimeGoal(3);
		 wtest.setStudyTime(8);
		
		 Float timePercent = tgtest.calculateDonePercent(wtest.getStudyTime());
		 
		 Integer points = wtest.calculatePoints(timePercent, goalsPercent) ;
		 String feedback = wtest.generateFeedback(points);
		 
		 assertEquals(points, 6);
		 assertEquals(feedback, Constants.BAD_FEEDBACK);
		 
	 }
	 
	 
}
