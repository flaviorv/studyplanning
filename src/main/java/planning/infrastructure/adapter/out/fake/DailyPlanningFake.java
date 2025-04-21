package planning.infrastructure.adapter.out.fake;

import planning.domain.model.DailyPlanning;
import planning.domain.ports.out.IDailyPlanningRepository;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DailyPlanningFake implements IDailyPlanningRepository {
    private static volatile DailyPlanningFake instance = new DailyPlanningFake();
    private List<DailyPlanning> planning = new ArrayList<>();

    private DailyPlanningFake() {}

    public static DailyPlanningFake getInstance() {
        if (instance == null) {
            instance = new DailyPlanningFake();
        }
        return instance;
    }

    @Override
    public void save(DailyPlanning planning) {
        this.planning.add(planning);
    }

    @Override
    public void edit(DailyPlanning planning) {
        this.planning.remove(planning);
    }

    @Override
    public void delete(DailyPlanning planning) {
        this.planning.remove(planning);
    }

    @Override
    public Optional<DailyPlanning> get(DayOfWeek day) {
        return this.planning.stream().filter(dp -> dp.getDay() == day).findFirst();
    }

    @Override
    public List<DailyPlanning> getAll() {
        return planning;
    }

}
