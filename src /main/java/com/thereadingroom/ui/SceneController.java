package com.thereadingroom.ui;

public class SceneController {

    /**
     * Helper method that loads an FXML file by name.
     * All scene switches go through this method.
     */
    private static void load(String fxmlName) {
        try {
            Main.changeScene(fxmlName.toLowerCase());
        } catch (Exception e) {
            System.err.println("❌ Failed to load scene: " + fxmlName);
            e.printStackTrace();
        }
    }

    public static void goToRegister() {
        load("register");
    }

    public static void goToLogin() {
        load("login");
    }

    public static void goToUserDashboard() {
        load("dashboard_user");
    }

    public static void goToAdminDashboard() {
        load("dashboard_admin");
    }
}
