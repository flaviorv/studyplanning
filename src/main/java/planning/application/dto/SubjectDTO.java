package planning.application.dto;

import planning.domain.model.Topic;

import java.util.List;

public class SubjectDTO {
    private final String subject;
    private final String startTime;
    private final String endTime;
    private List<Topic> topics;

   public SubjectDTO(String subject, String startTime, String endTime) {
       this.subject = subject;
       this.startTime = startTime;
       this.endTime = endTime;
   }

    public String getSubject() {
        return subject;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public List<Topic> getTopics() {
        return topics;
    }
}
