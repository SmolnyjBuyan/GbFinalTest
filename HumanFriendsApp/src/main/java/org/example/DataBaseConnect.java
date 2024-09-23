package org.example;

import java.sql.*;

public class DataBaseConnect {
    private static String dbUrl = "jdbc:mysql://localhost:3306/human_friends";
    private static String user = "root";
    private static String password = "Andrey6542564";
    private static Connection connection;

    public static Connection getConnection() {
        System.out.println("Try to create the database connection");
        try (Connection connection = DriverManager.getConnection(dbUrl, user, password)){
            System.out.println("Connection to database is successful");
        } catch (SQLException e) {
            System.out.println("Failed to create the database connection");
        }
        return connection;
    }
}
