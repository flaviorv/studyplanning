package com.frv.studyplanning.domain.model;

import com.frv.studyplanning.domain.model.exception.NoDayException;
import com.frv.studyplanning.domain.model.exception.NoSubjectsException;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class DailyPlanning {
    private DayOfWeek day;
    private List<Subject> subjects = new ArrayList<>();

    public boolean realizedGoals() {
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
        if (day == null) {
            throw new NoDayException("The day must be set before adding a subject.");
        }
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }
}
