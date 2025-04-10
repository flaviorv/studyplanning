package com.frv.studyplanning.model.domain;

import com.frv.studyplanning.domain.model.DailyPlanning;
import com.frv.studyplanning.domain.model.Subject;
import com.frv.studyplanning.domain.model.exception.NoDayException;
import com.frv.studyplanning.domain.model.exception.NoSubjectsException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class DailyPlanningTest {
    @Test
    void realizedGoalsExceptionTest() {
        DailyPlanning dp = new DailyPlanning();
        assertThrowsExactly(NoSubjectsException.class, dp::realizedGoals);

        Subject s = new Subject("Software Architecture", "12:00", "13:00");
        assertThrowsExactly(NoDayException.class, () -> dp.addSubject(s));
    }

    @Test
    void realizedGoalsTest() {
        DailyPlanning dp = new DailyPlanning();
        Subject s = new Subject(
                "Software Architecture",
                "16:00", "18:30"
        );

        dp.setDay(DayOfWeek.TUESDAY);
        dp.addSubject(s);
        dp.realizedGoals();
        assertFalse(dp.realizedGoals());

        s.setDone(LocalTime.of(16, 0), LocalTime.of(18, 30));
        assertTrue(dp.realizedGoals());
    }
}
