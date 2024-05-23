package com.example.gui_client_side.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
public class LoginController {

    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    @FXML
    public void onLogin(ActionEvent actionEvent) throws IOException {
        // Go to todo page
        gotoTodoPage();
    }
    // open the todo page
    private void gotoTodoPage() throws IOException {
        // close current satge
        closeCurrentWindow();
        String resourcePath = "/com/example/gui_client_side/todo_view.fxml";
        String title = "Todo";
        openNewWindow(resourcePath, title);
    }
    @FXML
    public void onGotoRegistation(ActionEvent actionEvent) throws IOException {
        closeCurrentWindow();
        String resourcePath = "/com/example/gui_client_side/registration_view.fxml";
        String title = "Registration";
        openNewWindow(resourcePath, title);
    }

    // Used to close login_view window
    private void closeCurrentWindow() {
        Stage currentStage=  (Stage) txtEmail.getScene().getWindow();
        currentStage.close();
    }

    // Use to open new window
    public void openNewWindow(String path, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource(path));
        Scene scene = new Scene(loader.load(), 800, 650);
        Stage stage = new Stage();
        stage.setTitle(title);
        // add secene to the stage
        stage.setScene(scene);
        stage.show();
    }
}
