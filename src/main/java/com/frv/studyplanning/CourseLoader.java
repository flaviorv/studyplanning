package com.frv.studyplanning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class CourseLoader implements ApplicationRunner{
	
	public void run(ApplicationArguments args) {
		System.out.println("Starting CourseLoader");
	}
}
