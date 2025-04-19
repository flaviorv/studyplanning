package planning.model.domain;

import planning.domain.model.Subject;
import org.junit.jupiter.api.Test;
import planning.domain.model.exception.EndBeforeStartException;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {
    @Test
    void setSubjectExceptionTest() {
        assertThrowsExactly(NullPointerException.class, () -> new Subject("Clean Code", null, LocalTime.of(13, 0)));
        assertThrowsExactly(NullPointerException.class, () -> new Subject("Clean Code", LocalTime.of(13, 0), null));
        assertThrowsExactly(NullPointerException.class, () -> new Subject(null, LocalTime.of(13, 0), LocalTime.of(14, 0)));
        assertThrowsExactly(IllegalArgumentException.class, () -> new Subject("", LocalTime.of(13, 0), LocalTime.of(14, 0)));
        assertThrowsExactly(EndBeforeStartException.class, () -> new Subject("Clean Code", LocalTime.of(13, 1), LocalTime.of(13, 0)));
    }

    @Test
    void isSameTimeTest(){
        Subject s = new Subject("Machine Learning", LocalTime.of(14, 0), LocalTime.of(15, 30));
        assertTrue(s.isSameTime(s.getStartTime(), LocalTime.of(14, 10)));
        assertFalse(s.isSameTime(s.getStartTime(), LocalTime.of(13, 49)));
        assertFalse(s.isSameTime(s.getEndTime(), LocalTime.of(15, 19)));
        assertFalse(s.isSameTime(s.getStartTime(), LocalTime.of(14, 11)));
        assertTrue(s.isSameTime(s.getEndTime(), LocalTime.of(15, 20)));
    }

    @Test
    void checkIsDoneTest(){
        Subject s = new Subject("Linux", LocalTime.of(8,0), LocalTime.of(9,0));
        assertFalse(s.checkIsDone(s.getStartTime(), LocalTime.of(8,49)));
        assertTrue(s.checkIsDone(s.getStartTime(), LocalTime.of(8,50)));
        assertFalse(s.checkIsDone(LocalTime.of(8, 11), LocalTime.of(8,50)));
        assertFalse(s.checkIsDone(LocalTime.of(7, 0), LocalTime.of(9,0)));
    }

}
