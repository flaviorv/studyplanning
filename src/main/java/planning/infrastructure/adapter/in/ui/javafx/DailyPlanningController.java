package planning.infrastructure.adapter.in.ui.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import planning.application.service.DailyPlanningUseCase;
import planning.domain.model.DailyPlanning;
import planning.domain.model.Subject;
import planning.domain.ports.in.IDailyPlanningUseCase;
import planning.domain.ports.out.IDailyPlanningRepository;
import planning.infrastructure.adapter.out.fake.DailyPlanningFake;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class DailyPlanningController {
    private final IDailyPlanningRepository repository = new DailyPlanningFake();
    private final IDailyPlanningUseCase useCase = new DailyPlanningUseCase(repository);

    @FXML protected FlowPane days;
    @FXML protected Label planning;
    @FXML protected TableView<Subject> subjects;
    @FXML protected TableColumn<Subject, String> subject;
    @FXML protected TableColumn<Subject, String> startTime;
    @FXML protected TableColumn<Subject, String> endTime;
    @FXML protected TableColumn<Subject, String> done;

    @FXML
    protected void initialize() {
        handleDayButtons();
        handleTable();
        DailyPlanning dp = new DailyPlanning(DayOfWeek.MONDAY);
        Subject s1 = new Subject(
                "Clean Code", LocalTime.of(16,0), LocalTime.of(18,30)
        );
        dp.addSubject(s1);
        Subject s2 = new Subject(
                "Data Structures", LocalTime.of(16,0), LocalTime.of(18,30)
        );
        try {
            dp.addSubject(s2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid field");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        Subject s3 = new Subject("Data Structures", LocalTime.of(12,0), LocalTime.of(13,30));
        dp.addSubject(s3);
        useCase.save(dp);

        getTodayPlanning();
    }

    private void handleDayButtons() {
        for (DayOfWeek day : DayOfWeek.values()) {
            Button b = new Button(day.name());
            b.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-cursor: hand;");
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

    private void getTodayPlanning() {
        for (Node n : days.getChildren()) {
            if (n instanceof Button b) {
                if (b.getText().equals(LocalDate.now().getDayOfWeek().name())) {
                    b.fire();
                    break;
                }
            }
        }
    }

    private void getSubjects(Button b) {
        DayOfWeek day = DayOfWeek.valueOf(b.getText());
        Optional<DailyPlanning> dp =  useCase.get(day);
        subjects.setVisible(false);
        if (dp.isPresent()) {
            subjects.setItems(FXCollections.observableList(dp.get().getSubjects()));
            subjects.setVisible(true);
            planning.setText("Planning for " + day.name() + " : " + dp.get().getSubjects().size() + " subjects");
        } else {
            subjects.setVisible(false);
            planning.setText("No planning for " + day.name());
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
}
