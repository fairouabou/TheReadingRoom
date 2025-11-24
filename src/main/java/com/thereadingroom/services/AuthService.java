package com.thereadingroom.services;

import com.thereadingroom.database.Database;
import com.thereadingroom.models.User;
import com.thereadingroom.utils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    public static boolean register(String username, String password) {
        String hashed = PasswordUtils.hashPassword(password);

        String sql = "INSERT INTO users(username, password, role) VALUES (?, ?, 'user')";

        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, hashed);
            stmt.executeUpdate();

            stmt.close(); // IMPORTANT: close only statement

            return true;

        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

    public static User login(String username, String password) {
        String hashed = PasswordUtils.hashPassword(password);

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, hashed);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );

                stmt.close();
                return user;
            }

            stmt.close();

        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
        }

        return null;
    }
}
