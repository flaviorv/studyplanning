package planning.application.dto;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class DailyPlanningDTO {
    private DayOfWeek day;
    private List<SubjectDTO> subjects = new ArrayList<>();

    public DailyPlanningDTO(String day) {
        this.day = DayOfWeek.valueOf(day);
    }

    public DayOfWeek getDay() {
        return day;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }
}
