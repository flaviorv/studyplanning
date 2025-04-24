package planning.infrastructure.adapter.in.ui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import planning.application.dto.DailyPlanningDTO;
import planning.application.dto.SubjectDTO;
import planning.application.service.DailyPlanningUseCase;
import planning.domain.model.Session;
import planning.domain.ports.in.IDailyPlanningUseCase;
import java.io.IOException;
import java.time.DayOfWeek;

public class AddSubjectController {
    IDailyPlanningUseCase useCase = DailyPlanningUseCase.getInstance();

    @FXML private TextField subject;
    @FXML private TextField startHours;
    @FXML private TextField startMinutes;
    @FXML private TextField endHours;
    @FXML private TextField endMinutes;
    @FXML private Button confirmBtn;
    @FXML public Text errorText;

    @FXML
    protected void initialize() {
        toNext(startHours, startMinutes);
        toNext(startMinutes, endHours);
        toNext(endHours, endMinutes);
        toNext(endMinutes, confirmBtn);
    }

    @FXML
    protected void onAddSubjectBtnClick(ActionEvent event) {
        try {
            DayOfWeek currentDay = Session.getDay();
            DailyPlanningDTO dto = new DailyPlanningDTO(currentDay.toString());
            String startTime = startHours.getText() + ":" + startMinutes.getText();
            String endTime = endHours.getText() + ":" + endMinutes.getText();
            SubjectDTO subjectDTO = new SubjectDTO(subject.getText(), startTime, endTime);
            dto.getSubjects().add(subjectDTO);
            useCase.add(dto, subjectDTO);
            ViewUtils.changeView(event, "DailyPlanningView");
        }catch (IOException e) {
            errorText.setText("An error occurred. Please, try again later.");
            errorText.setVisible(true);
            //should be created a page for this exception
        }catch (Exception e) {
            errorText.setText(e.getMessage());
            errorText.setVisible(true);
        }
    }

    private <T extends Node> void toNext(TextField current, T next) {
        current.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().length() < 2) {
                current.setText(newValue);
            } else {
                if (newValue.trim().length() > 2) {
                    current.setText(newValue.substring(0, 2));
                }
                next.requestFocus();
            }
        });
    }
}