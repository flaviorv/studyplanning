package com.frv.studyplanning.model.domain;

import com.frv.studyplanning.domain.model.domain.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

public class SubjectTest {
    @Test
    void isSameTimeTest(){
        Subject subject = new Subject();
        subject.setStartTime(LocalTime.of(14, 0));
        subject.setEndTime(LocalTime.of(15, 30));
        Assertions.assertFalse(subject.isSameTime(subject.getStartTime(), LocalTime.of(14, 11), 10));
        Assertions.assertTrue(subject.isSameTime(subject.getStartTime(), LocalTime.of(14, 10), 10));
        Assertions.assertFalse(subject.isSameTime(subject.getStartTime(), LocalTime.of(13, 49), 10));
        Assertions.assertFalse(subject.isSameTime(subject.getEndTime(), LocalTime.of(15, 19), 10));
        Assertions.assertTrue(subject.isSameTime(subject.getEndTime(), LocalTime.of(15, 20), 10));
    }

    @Test
    void setDoneTest(){
        Subject subject = new Subject();
        subject.setStartTime(LocalTime.of(8,0));
        subject.setEndTime(LocalTime.of(9,0));
        Assertions.assertFalse(subject.setDone(subject.getStartTime(), LocalTime.of(8,49)));
        Assertions.assertTrue(subject.setDone(subject.getStartTime(), LocalTime.of(8,50)));
        Assertions.assertFalse(subject.setDone(LocalTime.of(8, 11), LocalTime.of(8,50)));
    }
}
