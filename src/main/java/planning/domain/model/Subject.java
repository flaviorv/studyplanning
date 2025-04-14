package planning.domain.model;

import planning.domain.model.exception.EndBeforeStartException;
import planning.domain.model.exception.NoStartTimeException;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Subject {
    private String subject;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean done;
    private List<Topic> topics;

    public Subject(String subject, LocalTime startTime, LocalTime endTime) {
        this.subject = subject;
        this.startTime = startTime;
        this.setEndTime(endTime);
        this.done = false;
    }

    public Subject(){}

    public boolean isSameTime(LocalTime time1, LocalTime time2){
        final int TOLERANCE = 10;
        long difference = Math.abs(Duration.between(time1, time2).toMinutes());
        return difference <= TOLERANCE;
    }

    public boolean setDone(LocalTime sessionStartTime, LocalTime sessionEndTime) {
        if(isSameTime(sessionEndTime, endTime)) {
            if (sessionStartTime.isBefore(startTime) || isSameTime(sessionStartTime, startTime)) {
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
        if (startTime == null) {
            throw  new NoStartTimeException("Start time should be set before end time.");
        }
        if (startTime.isAfter(endTime)) {
            throw new EndBeforeStartException("End time should be after start time.");
        }
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
