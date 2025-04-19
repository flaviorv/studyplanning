package planning.model.domain;

import org.junit.jupiter.api.Test;
import planning.infrastructure.adapter.out.fake.DailyPlanningFake;

import java.time.DayOfWeek;

public class PlanningServiceTest {
    @Test
    public void test() {
        DailyPlanningFake planningService = new DailyPlanningFake();
        planningService.registerPlanning(DayOfWeek.MONDAY);
        System.out.println();
    }
}
