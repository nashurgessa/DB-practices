module com.example.gui_client_side {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;

    exports com.example.gui_client_side.controller to javafx.fxml;
    opens com.example.gui_client_side.controller to javafx.fxml;

    opens com.example.gui_client_side to javafx.fxml;
    exports com.example.gui_client_side;
}