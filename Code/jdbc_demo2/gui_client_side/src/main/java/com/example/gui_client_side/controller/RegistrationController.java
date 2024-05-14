package com.example.gui_client_side.controller;

import com.example.gui_client_side.service.UserService;
import com.example.gui_client_side.utils.RegistrationResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConPassword;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;

    UserService userService = new UserService();

    @FXML
    public void OnRegisterClicked(ActionEvent actionEvent) throws IOException {

        // Chcek if password and confirmPassword matches
        RegistrationResult result = userRegister(txtName.getText(), txtEmail.getText(), txtPassword.getText(), txtConPassword.getText());
        if (result == RegistrationResult.PASSWORD_MISMATCH) {
            System.out.println("password mismatch");
        }
        else if (result == RegistrationResult.SUCCESS) {
            // After Registration, I need to go back to Login
            onBackToLogin();
        }
        else {
            // Alert
            System.out.println("Registration failed");
        }

    }

    private RegistrationResult userRegister(String name, String email, String password, String conPassword) {
        if (!password.equals(conPassword)){
            return RegistrationResult.PASSWORD_MISMATCH;
        }
        if (!name.isEmpty()) {
            boolean registrationResult = userService.registerUser(name, email, password);
            if(registrationResult) {
                return RegistrationResult.SUCCESS;
            }
        }
        return RegistrationResult.REGISTRATION_FAILED;

    }

    @FXML
    public void onSignInClicked(ActionEvent actionEvent) throws IOException {
        onBackToLogin();
    }

    void onBackToLogin() throws IOException {
        closeCurrentWindow();
        String loginResource = "/com/example/gui_client_side/login_view.fxml";
        String title = "Todo Application";
        openNewWindow(loginResource, title);
    }

    // Used to close login_view window
    private void closeCurrentWindow() {
        Stage currentStage=  (Stage) txtName.getScene().getWindow();
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
