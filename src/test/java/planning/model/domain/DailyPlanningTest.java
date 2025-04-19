package planning.model.domain;

import planning.domain.model.Subject;
import planning.domain.model.DailyPlanning;
import planning.domain.model.exception.NoSubjectsException;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanningTest {
    @Test
    void addSubjectExceptionTest() {
        DailyPlanning dp = new DailyPlanning(null);
        Subject s = new Subject();

    }

    @Test
    void reachesDailyGoalExceptionTest() {
        DailyPlanning dp = new DailyPlanning(DayOfWeek.TUESDAY);
        assertThrowsExactly(NoSubjectsException.class, dp::reachesDailyGoal);
    }

    @Test
    void reachesDailyGoalTest() {
        DailyPlanning dp = new DailyPlanning(DayOfWeek.WEDNESDAY);
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
