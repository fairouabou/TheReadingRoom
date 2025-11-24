module com.thereadingroom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Export main app package
    exports com.thereadingroom;

    // Export database package so HelloApplication can call DatabaseInitializer
    exports com.thereadingroom.database;

    // Open packages for JavaFX & reflection
    opens com.thereadingroom to javafx.fxml;
    opens com.thereadingroom.database to javafx.fxml;
    opens com.thereadingroom.ui.auth to javafx.fxml;
    opens com.thereadingroom.ui.dashboard to javafx.fxml;
    opens com.thereadingroom.utils to javafx.fxml;
}
