package planning.domain.model;

import planning.domain.model.exception.EndBeforeStartException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Subject {
    private String subject;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean done;
    private List<Topic> topics;

    public Subject(String subject, LocalTime startTime, LocalTime endTime) {
        if (subject.length() < 2) {
            throw new IllegalArgumentException("Subject must be at least 2 characters long.");
        }
        this.subject = subject;
        this.startTime = startTime;;
        if (startTime.isAfter(endTime)) {
            throw new EndBeforeStartException("End time should be after start time.");
        }
        this.endTime = endTime;
        this.done = false;
    }

    public Subject(){}

    @Override
    public String toString() {
        return "Subject: " + subject + "Start time: " + startTime + "End time: " + endTime + "Done: " + done;
    }

    public boolean isSameTime(LocalTime time1, LocalTime time2){
        final int TOLERANCE = 10;
        long difference = Math.abs(Duration.between(time1, time2).toMinutes());
        return difference <= TOLERANCE;
    }

    public boolean checkIsDone(LocalTime sessionStartTime, LocalTime sessionEndTime) {
        if(isSameTime(sessionEndTime, endTime)) {
            if (isSameTime(sessionStartTime, startTime)) {
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

    public boolean isDone() {
        return done;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public LocalTime getEndTime(){
        return this.endTime;
    }
}
