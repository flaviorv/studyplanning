package com.frv.studyplanning.model.domain;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
	
	@Test
	void authTest() {
		
		Student stest = new Student("João Carlos", "jc@gmail.com", "123");
		
		assertTrue(stest.authenticate("123"));
		assertFalse(stest.authenticate("321"));
		assertFalse(stest.authenticate(""));
	}
}

