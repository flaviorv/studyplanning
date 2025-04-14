package planning.domain.service;

import planning.domain.model.DailyPlanning;
import planning.domain.model.Subject;
import java.time.DayOfWeek;


public class PlanningService {
    public static void registerSubject(DailyPlanning dp, Subject s) {
        dp.addSubject(s);
    }

    public DailyPlanning registerPlanning(DayOfWeek day) {
        return new DailyPlanning(day);
    }
}
