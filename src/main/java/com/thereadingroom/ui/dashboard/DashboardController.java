package com.thereadingroom.ui.dashboard;

import com.thereadingroom.utils.SceneManager;
import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    public void goToBooks() {
        SceneManager.switchTo("/views/books/books.fxml");
    }

    @FXML
    public void goToFriends() {
        SceneManager.switchTo("/views/friends/friends.fxml");
    }

    @FXML
    public void goToDiscussions() {
        SceneManager.switchTo("/views/discussions/discussions.fxml");
    }

    @FXML
    public void logout() {
        SceneManager.switchTo("/views/auth/login.fxml");
    }
}
