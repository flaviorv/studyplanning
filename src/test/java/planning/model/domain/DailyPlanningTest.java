package planning.model.domain;

import planning.domain.model.Subject;
import planning.domain.model.DailyPlanning;
import planning.domain.model.exception.TimeIntervalException;
import planning.domain.model.exception.NoSubjectsException;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanningTest {
    @Test
    void addSubjectExceptionTest() {
        DailyPlanning dp = new DailyPlanning(null);
        Subject s1 = new Subject("Cyber Security", LocalTime.of(16,0), LocalTime.of(18,30));
        Subject s2 = new Subject("Java", LocalTime.of(16,0), LocalTime.of(17,30));
        Subject s3 = new Subject("Rust", LocalTime.of(13,10), LocalTime.of(18,30));
        Subject s4 = new Subject("Clean Code", LocalTime.of(13,0), LocalTime.of(19,30));
        assertDoesNotThrow(() -> dp.addSubject(s1));
        assertThrowsExactly(TimeIntervalException.class, () -> dp.addSubject(s2));
        assertThrowsExactly(TimeIntervalException.class, () -> dp.addSubject(s3));
        assertThrowsExactly(TimeIntervalException.class, () -> dp.addSubject(s4));
    }

    @Test
    void reachesDailyGoalExceptionTest() {
        DailyPlanning dp = new DailyPlanning(java.time.DayOfWeek.TUESDAY);
        assertThrowsExactly(NoSubjectsException.class, dp::reachesDailyGoal);
    }

    @Test
    void reachesDailyGoalTest() {
        DailyPlanning dp = new DailyPlanning(java.time.DayOfWeek.WEDNESDAY);
        Subject s = new Subject(
                "Software Architecture",
                LocalTime.of(16,0),
                LocalTime.of(18,30)
        );
        dp.addSubject(s);
        dp.reachesDailyGoal();
        assertFalse(dp.reachesDailyGoal());
        s.checkIsDone(LocalTime.of(16, 0), LocalTime.of(18, 30));
        assertTrue(dp.reachesDailyGoal());
    }
}
