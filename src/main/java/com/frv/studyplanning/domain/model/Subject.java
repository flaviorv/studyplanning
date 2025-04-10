package com.frv.studyplanning.domain.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Subject {
    private String subject;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean done;
    private List<Topic> topics;

    public Subject(String subject, String startTime, String endTime) {
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);

        this.subject = subject;
        this.startTime = start;
        this.endTime = end;
        this.done = false;
    }

    public Subject(){}

    public boolean isSameTime(LocalTime time1, LocalTime time2, int minTolerance){
        long difference = Math.abs(Duration.between(time1, time2).toMinutes());
        return difference <= minTolerance;
    }

    public boolean setDone(LocalTime sessionStartTime, LocalTime sessionEndTime) {
        if(isSameTime(sessionEndTime, endTime, 10)) {
            if (sessionStartTime.isBefore(startTime) || isSameTime(sessionStartTime, startTime, 10)) {
                return done = true;
            }
        }
        return done = false;
    }

    public String getSubject(){
        return this.subject;
    }

    public LocalTime getStartTime(){
        return this.startTime;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public LocalTime getEndTime(){
        return this.endTime;
    }
}
