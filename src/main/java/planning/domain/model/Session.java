package planning.domain.model;

import java.time.DayOfWeek;

public class Session {
    private static DayOfWeek day;

    public static DayOfWeek getDay() {
        return day;
    }
    public static void setDay(DayOfWeek day) {
        Session.day = day;
    }
    public static void resetDailyPlanning() {
        Session.day = null;
    }
}
