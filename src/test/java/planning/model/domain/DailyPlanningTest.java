package planning.model.domain;

import planning.domain.model.Subject;
import planning.domain.model.exception.NoDayException;
import planning.domain.model.DailyPlanning;
import planning.domain.model.exception.NoEndTimeException;
import planning.domain.model.exception.NoSubjectException;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanningTest {
    @Test
    void addSubjectExceptionTest() {
        DailyPlanning dp = new DailyPlanning();
        Subject s = new Subject();
        s.setStartTime(LocalTime.of(8, 0));
        assertThrowsExactly(NoDayException.class, () -> dp.addSubject(s));
        dp.setDay(DayOfWeek.TUESDAY);
        assertThrowsExactly(NoSubjectException.class, () -> dp.addSubject(s));
        s.setSubject("Clean Code");
        assertThrowsExactly(NoEndTimeException.class, () -> dp.addSubject(s));
    }

    @Test
    void realizedGoalsExceptionTest() {
        DailyPlanning dp = new DailyPlanning();
        assertThrowsExactly(NoSubjectException.class, dp::realizedGoals);
    }

    @Test
    void realizedGoalsTest() {
        DailyPlanning dp = new DailyPlanning();
        Subject s = new Subject(
                "Software Architecture",
                LocalTime.of(16,0),
                LocalTime.of(18,30)
        );

        dp.setDay(DayOfWeek.TUESDAY);
        dp.addSubject(s);
        dp.realizedGoals();
        assertFalse(dp.realizedGoals());
        s.setDone(LocalTime.of(16, 0), LocalTime.of(18, 30));
        assertTrue(dp.realizedGoals());
    }
}
