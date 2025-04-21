package planning.domain.ports.in;

import planning.application.dto.DailyPlanningDTO;
import planning.application.dto.SubjectDTO;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface IDailyPlanningUseCase {
    void add(DailyPlanningDTO planning, SubjectDTO subject);
    void edit(DailyPlanningDTO planning);
    void delete(DailyPlanningDTO planning);
    Optional<DailyPlanningDTO> get(DayOfWeek day);
    List<DailyPlanningDTO> getAll();
    List<DayOfWeek> getDays();
}
