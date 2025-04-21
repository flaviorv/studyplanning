package planning.infrastructure.adapter.in.ui.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import planning.application.dto.DailyPlanningDTO;
import planning.application.dto.SubjectDTO;
import planning.application.service.DailyPlanningUseCase;
import planning.domain.model.Session;
import planning.domain.ports.in.IDailyPlanningUseCase;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public class DailyPlanningController {
    private final IDailyPlanningUseCase useCase = DailyPlanningUseCase.getInstance();

    @FXML protected FlowPane days;
    @FXML protected Label planning;
    @FXML protected TableView<SubjectDTO> subjects;
    @FXML protected TableColumn<SubjectDTO, String> subject;
    @FXML protected TableColumn<SubjectDTO, String> startTime;
    @FXML protected TableColumn<SubjectDTO, String> endTime;
    @FXML protected TableColumn<SubjectDTO, String> done;
    @FXML protected Button addButton;
    @FXML protected Button addMoreButton;
    @FXML protected Button configButton;
    private DayOfWeek currentDay;

    @FXML
    protected void initialize() {
        currentDay = Session.getDay();
        handleDayButtons();
        handleTable();
        getCurrentPlanning();
    }

    private void handleDayButtons() {
        for (DayOfWeek day : DayOfWeek.values()) {
            Button b = new Button(day.name());
            b.setOnAction(event -> {
                for (Node _b : days.getChildren()) {
                    _b.setDisable(false);
                    _b.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-cursor: hand;");
                }
                b.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");
                b.setDisable(true);
                getSubjects(b);
            });
            days.getChildren().add(b);
        }
    }

    private void getCurrentPlanning() {
        if (currentDay == null) {
            currentDay = LocalDate.now().getDayOfWeek();
        }
        for (Node n : days.getChildren()) {
            if (n instanceof Button b) {
                if (b.getText().equals(currentDay.name())) {
                    b.fire();
                    break;
                }
            }
        }
    }

    private void getSubjects(Button b) {
        currentDay = DayOfWeek.valueOf(b.getText());
        Optional<DailyPlanningDTO> dto =  useCase.get(currentDay);
        if (dto.isPresent()) {
            subjects.setItems(FXCollections.observableList(dto.get().getSubjects()));
            subjects.setVisible(true);
            planning.setText("Planning for " + currentDay.name() + " : " + dto.get().getSubjects().size() + " subjects");
            addButton.setVisible(false);
            addButton.setManaged(false);
            addMoreButton.setVisible(true);
            addMoreButton.setManaged(true);
            configButton.setVisible(true);
            configButton.setManaged(true);
        } else {
            subjects.setVisible(false);
            planning.setText("No planning for " + currentDay.name());
            addButton.setVisible(true);
            addButton.setManaged(true);
            addMoreButton.setVisible(false);
            addMoreButton.setManaged(false);
            configButton.setVisible(false);
            configButton.setManaged(false);
        }

    }

    private void handleTable() {
        subject.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSubject()));
        startTime.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStartTime().toString()));
        endTime.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEndTime().toString()));
        done.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().isDone() ? "Done" : "Not done"));

        subject.setStyle("-fx-alignment: CENTER;");
        startTime.setStyle("-fx-alignment: CENTER;");
        endTime.setStyle("-fx-alignment: CENTER;");
        done.setStyle("-fx-alignment: CENTER;");

        subjects.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    public void toAddSubjectView(ActionEvent event) throws IOException {
        Session.setDay(currentDay);
        ViewUtils.changeView(event,"AddSubjectView");
    }

    @FXML
    public void toPlanningSettingsView(ActionEvent event) throws IOException {
        ViewUtils.changeView(event,"PlanningSettingsView");
    }
}
