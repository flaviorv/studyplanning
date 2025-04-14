package planning.model.domain;

import org.junit.jupiter.api.Test;
import planning.domain.service.PlanningService;

import java.time.DayOfWeek;

public class PlanningServiceTest {
    @Test
    public void test() {
        PlanningService planningService = new PlanningService();
        planningService.registerPlanning(DayOfWeek.MONDAY);
        System.out.println();
    }
}
