module planning.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens planning to javafx.fxml;
    exports planning;
    exports planning.application.controller;
    opens planning.application.controller to javafx.fxml;
}