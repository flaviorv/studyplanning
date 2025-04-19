module planning.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;
    requires java.desktop;

    opens planning to javafx.fxml;
    exports planning;
    exports planning.infrastructure.adapter.in.ui.javafx;
    opens planning.infrastructure.adapter.in.ui.javafx to javafx.fxml;
}