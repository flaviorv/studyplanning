package planning.infrastructure.adapter.in.ui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML private Label title;
    @FXML private TextField subject;
    @FXML private TextField startHours;
    @FXML private TextField startMinutes;
    @FXML private TextField endHours;
    @FXML private TextField endMinutes;
    @FXML private Button confirmBtn;
    @FXML public Text startTimeError;
    @FXML public Text endTimeError;

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
        }catch (Exception e) {
            e.printStackTrace();
            title.setText("Cannot add subject");
        }
    }

    private <T extends Node> void toNext(TextField current, T next) {
        current.textProperty().addListener((observable, oldValue, newValue) -> {
            String time;
            if (current.equals(startHours) || current.equals(startMinutes)) {
                time = "start";
            } else {
                time = "end";
            }

            isTimeValid(time);
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

    private  void isTimeValid(String time) {
        TextField hours, minutes;
        Text error;
        if (time == "start") {
            hours = startHours;
            minutes = startMinutes;
            error = startTimeError;
        } else {
            hours = endHours;
            minutes = endMinutes;
            error = endTimeError;
        }
        try {
            if (minutes.getText() != "") {
                int _minutes = Integer.parseInt(minutes.getText());
                if (_minutes > 59 || _minutes < 0) {
                    throw new IOException("Invalid minutes");
                }
            }
            if (hours.getText() != "") {
                int _hours = Integer.parseInt(hours.getText());
                if (_hours > 23 || _hours < 1){
                    throw new IOException("Invalid hours");
                }
            }
        } catch (IOException e1) {
            error.setText(e1.getMessage());
            hours.setStyle("-fx-text-fill: red");
            minutes.setStyle("-fx-text-fill: red");
            error.setVisible(true);
            error.setManaged(true);
            return;
        } catch (NumberFormatException e2) {
            error.setText("Time must be a number");
            hours.setStyle("-fx-text-fill: red");
            minutes.setStyle("-fx-text-fill: red");
            error.setVisible(true);
            error.setManaged(true);
            return;
        }
        hours.setStyle("-fx-text-fill: black");
        minutes.setStyle("-fx-text-fill: black");
        error.setVisible(false);
        error.setManaged(false);
    }


}