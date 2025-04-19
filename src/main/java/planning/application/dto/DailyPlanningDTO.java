package planning.application.dto;

import java.time.DayOfWeek;

public class DailyPlanningDTO {
    private DayOfWeek day;

    public DailyPlanningDTO(String day) {
        this.day = DayOfWeek.valueOf(day);
    }

    public DayOfWeek getDay() {
        return day;
    }
}
