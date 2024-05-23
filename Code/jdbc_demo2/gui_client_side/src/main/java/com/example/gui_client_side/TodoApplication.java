package com.example.gui_client_side;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoApplication.class
                .getResource("/com/example/gui_client_side/login_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 650);
        stage.setTitle("Todo Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}