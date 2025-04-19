package planning.application.service;

import planning.domain.model.DailyPlanning;
import planning.domain.ports.in.IDailyPlanningUseCase;
import planning.domain.ports.out.IDailyPlanningRepository;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public class DailyPlanningUseCase implements IDailyPlanningUseCase {
    private final IDailyPlanningRepository repository;

    public DailyPlanningUseCase(IDailyPlanningRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(DailyPlanning planning) {
        repository.save(planning);
    }

    @Override
    public void edit(DailyPlanning planning) {
        repository.edit(planning);
    }

    @Override
    public void delete(DailyPlanning planning) {
        repository.delete(planning);
    }

    @Override
    public Optional<DailyPlanning> get(DayOfWeek day) {
        return repository.get(day);
    }

    @Override
    public List<DailyPlanning> getAll() {
        return repository.getAll();
    }

    @Override
    public List<DayOfWeek> getDays() {
        return List.of(DayOfWeek.values());
    }

}
