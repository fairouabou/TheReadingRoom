package com.thereadingroom;

import com.thereadingroom.database.DatabaseInitializer;
import com.thereadingroom.utils.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        System.out.println("HelloApplication: START METHOD ENTERED");

        // Run DB initializer
        DatabaseInitializer.initialize();
        System.out.println("HelloApplication: INITIALIZER CALLED");

        // Set the stage for SceneManager
        SceneManager.setStage(stage);
        System.out.println("HelloApplication: STAGE SET");

        // Load login screen
        SceneManager.switchTo("/views/auth/login.fxml");
        System.out.println("HelloApplication: LOADED LOGIN SCREEN");

        stage.setTitle("The Reading Room");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
