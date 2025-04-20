package planning.infrastructure.adapter.in.ui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;

public class ViewUtils {
    protected static void changeView(ActionEvent event, String view) throws IOException {
        Parent loader = FXMLLoader.load(Objects.requireNonNull(ViewUtils.class.getResource("/view/" + view + ".fxml")));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(loader);
    }

}
