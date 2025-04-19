package planning.domain.model;

import planning.domain.model.exception.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DailyPlanning {
    private DayOfWeek day;
    private List<Subject> subjects = new ArrayList<>();

    public DailyPlanning(DayOfWeek day) {
        this.day = day;
    }

    public boolean reachesDailyGoal() {
        if (subjects.isEmpty()) {
            throw new NoSubjectsException("No subjects found. Therefore, there are no goals to realize.");
        }
        for (Subject subject : subjects) {
            if (!subject.isDone()) {
                return false;
            }
        }
        return true;
    }

    public void addSubject(Subject subject) {
        for (Subject s : subjects) {
            if (haveSameInterval(s, subject)) {
                throw new IntervalTimeException("The interval time reaches other interval time.");
            }
        }
        subjects.add(subject);
    }

    public boolean haveSameInterval(Subject s1, Subject s2) {
        LocalTime start1 = s1.getStartTime();
        LocalTime start2 = s2.getStartTime();
        LocalTime end1 = s1.getEndTime();
        LocalTime end2 = s2.getEndTime();

        if (start1.isBefore(start2) && end1.isBefore(start2)) {
            return false;
        }
        if (start1.isAfter(end2) && end1.isAfter(end2)) {
            return false;
        }
        return true;

    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public DayOfWeek getDay() {
        return day;
    }

}
