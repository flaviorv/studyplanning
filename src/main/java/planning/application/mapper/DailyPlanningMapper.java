package planning.application.mapper;

import planning.application.dto.DailyPlanningDTO;
import planning.domain.model.DailyPlanning;
public class DailyPlanningMapper {
    public static DailyPlanning toDomain(DailyPlanningDTO planning) {
        return new DailyPlanning(planning.getDay());
    }

    public static DailyPlanningDTO toDTO(DailyPlanning planning) {
        return new DailyPlanningDTO(planning.getDay().toString());
    }
}
