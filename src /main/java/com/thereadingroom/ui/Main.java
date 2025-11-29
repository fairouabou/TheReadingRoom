package com.thereadingroom.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.util.Objects;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        // Load login.fxml safely
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("/fxml/login.fxml"),
                "❌ login.fxml not found in /resources/fxml/"
        ));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Reading Room");
        primaryStage.show();
    }

    /**
     * Changes scenes by loading an FXML file from src/main/resources/fxml
     */
    public static void changeScene(String fxml) throws Exception {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(
                Main.class.getResource("/fxml/" + fxml + ".fxml"),
                "❌ Cannot load: " + fxml + ".fxml"
        ));

        stage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
