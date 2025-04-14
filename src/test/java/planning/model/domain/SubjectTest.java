package planning.model.domain;

import planning.domain.model.Subject;
import org.junit.jupiter.api.Test;
import planning.domain.model.exception.EndBeforeStartException;
import planning.domain.model.exception.NoStartTimeException;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {
    @Test
    void setSubjectExceptionTest() {
        Subject s = new Subject();
        assertThrowsExactly(NoStartTimeException.class, () -> s.setEndTime(LocalTime.of(13, 0)));
        s.setStartTime(LocalTime.of(13, 1));
        assertThrowsExactly(EndBeforeStartException.class, () -> s.setEndTime(LocalTime.of(13, 0)));
    }

    @Test
    void isSameTimeTest(){
        Subject s = new Subject();
        s.setStartTime(LocalTime.of(14, 0));
        s.setEndTime(LocalTime.of(15, 30));
        assertTrue(s.isSameTime(s.getStartTime(), LocalTime.of(14, 10)));
        assertFalse(s.isSameTime(s.getStartTime(), LocalTime.of(13, 49)));
        assertFalse(s.isSameTime(s.getEndTime(), LocalTime.of(15, 19)));
        assertFalse(s.isSameTime(s.getStartTime(), LocalTime.of(14, 11)));
        assertTrue(s.isSameTime(s.getEndTime(), LocalTime.of(15, 20)));
    }

    @Test
    void setDoneTest(){
        Subject s = new Subject();
        s.setStartTime(LocalTime.of(8,0));
        s.setEndTime(LocalTime.of(9,0));
        assertFalse(s.setDone(s.getStartTime(), LocalTime.of(8,49)));
        assertTrue(s.setDone(s.getStartTime(), LocalTime.of(8,50)));
        assertFalse(s.setDone(LocalTime.of(8, 11), LocalTime.of(8,50)));
        assertTrue(s.setDone(LocalTime.of(7, 0), LocalTime.of(9,0)));
    }

}
