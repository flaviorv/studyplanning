package com.frv.studyplanning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class SubjectLoader implements ApplicationRunner {
	
	public void run(ApplicationArguments args) {
		System.out.println("TODO Implement SubjectLoader");
		
	}	
}
