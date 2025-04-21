package planning;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import planning.application.dto.DailyPlanningDTO;
import planning.application.dto.SubjectDTO;
import planning.application.service.DailyPlanningUseCase;
import java.io.IOException;
import java.time.DayOfWeek;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DailyPlanningUseCase useCase = DailyPlanningUseCase.getInstance();
        DailyPlanningDTO dto = new DailyPlanningDTO(DayOfWeek.MONDAY.name());
        SubjectDTO s1 = new SubjectDTO(
                "Clean Code", "16:00", "18:30"
        );
        SubjectDTO s3 = new SubjectDTO(
                "Data Structures", "12:00", "13:30"
        );
        useCase.add(dto, s1);
        useCase.add(dto, s3);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/view/DailyPlanningView.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 500);
        stage.setTitle("Study Planning");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}