package com.frv.studyplanning.model;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
	
	@Test
	void authTest() {
		Student st1 = new Student("João Carlos", "jc@gmail.com", "123");
		assertTrue(st1.authenticate("123"));
		assertFalse(st1.authenticate("321"));
		assertFalse(st1.authenticate(""));
		
	}

}

