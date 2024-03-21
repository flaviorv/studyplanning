package com.frv.studyplanning.model.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.frv.studyplanning.model.auxiliary.Constants;

@SpringBootTest
public class ContentTest {
	
	Content ctest = new Content();
	
	@Test
	void setType_notSalved() {
		
		assertFalse(ctest.setType(null));
		assertFalse(ctest.setType("SomeType"));
	}
	
	@Test
	void setType_saved() {
		
		assertTrue(ctest.setType(Constants.CONTENT_BOOK));
		assertTrue(ctest.setType(Constants.CONTENT_LINK));
		assertTrue(ctest.setType(Constants.CONTENT_KEYPOINT));
	}
}
