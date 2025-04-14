package planning.application.mapper;

import planning.application.dto.SubjectDTO;
import planning.domain.model.Subject;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class SubjectMapper {

    public static Subject toDomain(SubjectDTO dto) {
        try {
            LocalTime start = LocalTime.parse(dto.getStartTime());
            LocalTime end = LocalTime.parse(dto.getEndTime());
            return new Subject(dto.getSubject(), start, end);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Format: 24 hours. Use HH:mm.");
        }
    }

    public static SubjectDTO toDTO (Subject subject) {
        String startTime = subject.getStartTime().toString();
        String endTime = subject.getEndTime().toString();
        return new SubjectDTO(subject.getSubject(), startTime, endTime);
    }

}
