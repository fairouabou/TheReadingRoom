package com.thereadingroom.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class AdminDashboardController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void onBooks() {
        contentArea.getChildren().setAll(
                new Label("Books management will go here")
        );
    }

    @FXML
    public void onUsers() {
        contentArea.getChildren().setAll(
                new Label("Users management will go here")
        );
    }

    @FXML
    public void onDiscussions() {
        contentArea.getChildren().setAll(
                new Label("Discussions management will go here")
        );
    }

    @FXML
    public void onLogout() {
        SceneController.goToLogin();
    }
}
