package com.frv.studyplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import com.frv.studyplanning.test.*;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class StudyplanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyplanningApplication.class, args);
		System.out.println("Running sucefully");
		StudentTest st1 = new StudentTest();
		st1.showStudent();
	}

}
