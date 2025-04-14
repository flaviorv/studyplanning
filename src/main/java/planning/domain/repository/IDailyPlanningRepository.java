package planning.domain.repository;

import planning.domain.model.DailyPlanning;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IDailyPlanningRepository {
    public void save(DailyPlanning planning);
    public DailyPlanning all();
    public DailyPlanning byId(Long id);
    public DailyPlanning byDate(LocalDate date);
    public DailyPlanning byTime(LocalTime time);
}
