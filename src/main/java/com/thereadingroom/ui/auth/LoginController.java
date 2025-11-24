package com.thereadingroom.ui.auth;

import com.thereadingroom.models.User;
import com.thereadingroom.services.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.thereadingroom.utils.SceneManager;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty()) {

            System.out.println("Login error: username or password empty");
            return;
        }

        User user = AuthService.login(username, password);

        if (user != null) {
            System.out.println("Login successful!");
            // TODO: Change to dashboard
            SceneManager.switchTo("/views/dashboard/dashboard.fxml");
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    @FXML
    public void goToRegister() {
        SceneManager.switchTo("/views/auth/register.fxml");
    }

}
