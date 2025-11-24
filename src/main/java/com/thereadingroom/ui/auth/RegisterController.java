package com.thereadingroom.ui.auth;

import com.thereadingroom.services.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.thereadingroom.utils.SceneManager;


public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void handleRegister() {
        boolean success = AuthService.register(
                usernameField.getText(),
                passwordField.getText()
        );

        if (success) {
            System.out.println("Registration successful!");
            SceneManager.switchTo("/views/auth/login.fxml");
        } else {
            System.out.println("Registration failed.");
        }
    }

    @FXML
    public void goToLogin() {
        SceneManager.switchTo("/views/auth/login.fxml");
    }
}