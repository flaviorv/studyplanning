package planning.application.mapper;

import planning.application.dto.DailyPlanningDTO;
import planning.application.dto.SubjectDTO;
import planning.domain.model.DailyPlanning;
import planning.domain.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DailyPlanningMapper {
    public static DailyPlanning toDomain(DailyPlanningDTO dto) {
        List<Subject> subjects = dto.getSubjects().stream().map(SubjectMapper::toDomain).collect(Collectors.toCollection(ArrayList::new));
        DailyPlanning dp = new DailyPlanning(dto.getDay());
        dp.setSubjects(subjects);
        return dp;
    }

    public static DailyPlanningDTO toDTO(DailyPlanning planning) {
        List<SubjectDTO> subjectsDTO = planning.getSubjects().stream().map(SubjectMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
        DailyPlanningDTO dto = new DailyPlanningDTO(planning.getDay().toString());
        dto.setSubjects(subjectsDTO);
        return dto;
    }
}
