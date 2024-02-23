package com.frv.studyplanning.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeekTest {
	
	Week wtest = new Week();
	
	@Test
	void shold_subtracting_the_current_minutes_from_the_start_time() {
	//	startTime
		Integer twoPastMinutes = wtest.getCurrentMinutes() - 2;
		assertEquals(2, wtest.calculateStudyTime(twoPastMinutes));
	}
	
	 @Test
	 void shold_calculate_if_week_is_ended() {
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
}
