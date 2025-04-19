package planning.infrastructure.adapter.out.fake;

import planning.domain.model.DailyPlanning;
import planning.domain.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectFake {
    private List<Subject> subjects = new ArrayList<>();

    public  void registerSubject(DailyPlanning dp, Subject s) {
        dp.addSubject(s);
    }
}
