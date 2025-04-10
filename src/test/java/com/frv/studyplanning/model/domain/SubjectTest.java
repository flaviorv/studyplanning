package com.frv.studyplanning.model.domain;

import com.frv.studyplanning.domain.model.Subject;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

public class SubjectTest {
    @Test
    void isSameTimeTest(){
        Subject s = new Subject();
        s.setStartTime(LocalTime.of(14, 0));
        s.setEndTime(LocalTime.of(15, 30));
        assertTrue(s.isSameTime(s.getStartTime(), LocalTime.of(14, 10), 10));
        assertFalse(s.isSameTime(s.getStartTime(), LocalTime.of(13, 49), 10));
        assertFalse(s.isSameTime(s.getEndTime(), LocalTime.of(15, 19), 10));
        assertFalse(s.isSameTime(s.getStartTime(), LocalTime.of(14, 11), 10));
        assertTrue(s.isSameTime(s.getEndTime(), LocalTime.of(15, 20), 10));
    }

    @Test
    void setDoneTest(){
        Subject s = new Subject();
        s.setStartTime(LocalTime.of(8,0));
        s.setEndTime(LocalTime.of(9,0));
        assertFalse(s.setDone(s.getStartTime(), LocalTime.of(8,49)));
        assertTrue(s.setDone(s.getStartTime(), LocalTime.of(8,50)));
        assertFalse(s.setDone(LocalTime.of(8, 11), LocalTime.of(8,50)));
        assertTrue(s.setDone(LocalTime.of(7, 0), LocalTime.of(9,0)));
    }

}
