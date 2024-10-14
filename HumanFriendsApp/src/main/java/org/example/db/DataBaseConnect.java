package org.example.db;

import java.sql.*;

public class DataBaseConnect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/human_friends";
    private static final String USER = "root";
    private static final String PASSWORD = "Andrey6542564";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
