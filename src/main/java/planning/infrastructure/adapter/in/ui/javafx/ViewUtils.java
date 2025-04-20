package planning.infrastructure.adapter.in.ui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ViewUtils {
    protected static void changeView(ActionEvent event, String view) throws IOException {
        Parent loader = FXMLLoader.load(Objects.requireNonNull(ViewUtils.class.getResource("/view/" + view + ".fxml")));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader));
        stage.show();
    }

}
