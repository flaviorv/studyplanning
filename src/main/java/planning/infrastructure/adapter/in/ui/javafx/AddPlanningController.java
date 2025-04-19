package planning.infrastructure.adapter.in.ui.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import planning.application.dto.DailyPlanningDTO;
import planning.application.mapper.DailyPlanningMapper;
import planning.domain.model.DailyPlanning;
import planning.infrastructure.adapter.out.fake.DailyPlanningFake;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.DayOfWeek;
import java.util.Optional;

public class AddPlanningController {
    @FXML private Text title;
    @FXML private ComboBox<String> day;

    @FXML
    protected void initialize() {
//        getDays();
    }

    @FXML
    protected void addPlanning() {
//        DailyPlanningDTO dpDTO = new DailyPlanningDTO(day.getValue());
//        DailyPlanning dp = DailyPlanningMapper.toDomain(dpDTO);
//        DailyPlanningFake psf = new DailyPlanningFake();
//        Optional<DailyPlanning> odp= psf.registerPlanning(dp);
//        if (odp.isPresent()) {
//            dpDTO = DailyPlanningMapper.toDTO(dp);
//            title.setText(dpDTO.getDay().name());
//        }

    }

//    public void getDays(){
//        for (DayOfWeek day : DayOfWeek.values()) {
//            DailyPlanningFake psf = new DailyPlanningFake();
//            if (psf.getDays().contains(day)) {
//                throw new KeyAlreadyExistsException("Daily Planning of " + day + " already exists");
//            }
//            String dayName = day.name();
//            dayName = dayName.substring(0, 1).toUpperCase() + dayName.substring(1);
//            this.day.getItems().add(dayName);
//        }
//    }
}
