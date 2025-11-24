package com.thereadingroom.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        System.out.println("DATABASE INITIALIZER: STARTING...");

        String usersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL,
                role TEXT NOT NULL DEFAULT 'user',
                bio TEXT,
                profile_picture TEXT
            );
        """;

        String booksTable = """
            CREATE TABLE IF NOT EXISTS books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                author TEXT NOT NULL,
                category TEXT,
                cover_image TEXT
            );
        """;

        String userBooksTable = """
            CREATE TABLE IF NOT EXISTS user_books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                list_type TEXT NOT NULL,
                rating INTEGER,
                FOREIGN KEY(user_id) REFERENCES users(id),
                FOREIGN KEY(book_id) REFERENCES books(id)
            );
        """;

        String friendsTable = """
            CREATE TABLE IF NOT EXISTS friends (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id INTEGER NOT NULL,
                friend_id INTEGER NOT NULL,
                FOREIGN KEY(user_id) REFERENCES users(id),
                FOREIGN KEY(friend_id) REFERENCES users(id)
            );
        """;

        String suggestionsTable = """
            CREATE TABLE IF NOT EXISTS suggestions (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                sender_id INTEGER NOT NULL,
                receiver_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                FOREIGN KEY(sender_id) REFERENCES users(id),
                FOREIGN KEY(receiver_id) REFERENCES users(id),
                FOREIGN KEY(book_id) REFERENCES books(id)
            );
        """;

        String discussionsTable = """
            CREATE TABLE IF NOT EXISTS discussions (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                book_id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                message TEXT NOT NULL,
                timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY(book_id) REFERENCES books(id),
                FOREIGN KEY(user_id) REFERENCES users(id)
            );
        """;

        try {
            Connection conn = Database.getConnection();
            System.out.println("DATABASE INITIALIZER: CONNECTION = " + conn);

            Statement stmt = conn.createStatement();
            System.out.println("DATABASE INITIALIZER: RUNNING CREATE TABLE STATEMENTS...");

            stmt.execute(usersTable);
            stmt.execute(booksTable);
            stmt.execute(userBooksTable);
            stmt.execute(friendsTable);
            stmt.execute(suggestionsTable);
            stmt.execute(discussionsTable);

            stmt.close();
            System.out.println("DATABASE INITIALIZER: TABLE CREATION DONE.");

        } catch (SQLException e) {
            System.out.println("DATABASE INITIALIZER: ERROR OCCURRED!");
            e.printStackTrace();
        }
    }
}
