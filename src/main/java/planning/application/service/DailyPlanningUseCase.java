package planning.application.service;

import planning.application.dto.DailyPlanningDTO;
import planning.application.dto.SubjectDTO;
import planning.application.mapper.DailyPlanningMapper;
import planning.application.mapper.SubjectMapper;
import planning.domain.model.DailyPlanning;
import planning.domain.model.Subject;
import planning.domain.ports.in.IDailyPlanningUseCase;
import planning.domain.ports.out.IDailyPlanningRepository;
import planning.infrastructure.adapter.out.fake.DailyPlanningFake;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public class DailyPlanningUseCase implements IDailyPlanningUseCase {
    private final IDailyPlanningRepository repository;

    private DailyPlanningUseCase(IDailyPlanningRepository repository) {
        this.repository = repository;
    }

    private static DailyPlanningUseCase instance;

    public static DailyPlanningUseCase getInstance() {
        if (instance == null) {
            instance = new DailyPlanningUseCase(DailyPlanningFake.getInstance());
        }
        return instance;
    }

    @Override
    public void add(DailyPlanningDTO planningDTO, SubjectDTO subjectDTO) {
        Optional<DailyPlanning> odp = repository.get(planningDTO.getDay());
        DailyPlanning dp;
        dp = odp.orElseGet(() -> new DailyPlanning(planningDTO.getDay()));
        Subject s = SubjectMapper.toDomain(subjectDTO);
        dp.addSubject(s);
        repository.save(dp);
    }

    @Override
    public void edit(DailyPlanningDTO dto) {
        DailyPlanning dp = DailyPlanningMapper.toDomain(dto);
        repository.edit(dp);
    }

    @Override
    public void delete(DailyPlanningDTO dto) {
        DailyPlanning dp = DailyPlanningMapper.toDomain(dto);
        repository.delete(dp);
    }

    @Override
    public Optional<DailyPlanningDTO> get(DayOfWeek day) {
        Optional<DailyPlanning> dp = repository.get(day);
        return dp.map(DailyPlanningMapper::toDTO);
    }

    @Override
    public List<DailyPlanningDTO> getAll() {
        List<DailyPlanning> dps = repository.getAll();
        return dps.stream().map(DailyPlanningMapper::toDTO).toList();
    }

    @Override
    public List<DayOfWeek> getDays() {
        return List.of(DayOfWeek.values());
    }

}
