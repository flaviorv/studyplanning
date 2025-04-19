package planning.domain.ports.in;

import planning.domain.model.DailyPlanning;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface IDailyPlanningUseCase {
    void save(DailyPlanning planning);
    void edit(DailyPlanning planning);
    void delete(DailyPlanning planning);
    Optional<DailyPlanning> get(DayOfWeek day);
    List<DailyPlanning> getAll();
    List<DayOfWeek> getDays();
}
