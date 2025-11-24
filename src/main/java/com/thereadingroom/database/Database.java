package com.thereadingroom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:sqlite:thereadingroom.db";
    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                System.out.println("Database.getConnection(): Attempting connection to " + DB_URL);
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("Database.getConnection(): SUCCESSFUL CONNECTION → " + connection);
            } catch (SQLException e) {
                System.out.println("Database.getConnection(): FAILED");
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("Database.getConnection(): EXISTING CONNECTION → " + connection);
        }

        return connection;
    }
}
