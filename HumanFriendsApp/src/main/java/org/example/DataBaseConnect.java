package org.example;

import java.sql.*;

public class DataBaseConnect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/human_friends";
    private static final String USER = "root";
    private static final String PASSWORD = "Andrey6542564";

//    public static Connection getConnection() {
//        System.out.println("Try to create the database connection");
//        try {
//            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//            System.out.println("Connection to database is successful");
//            return connection;
//        } catch (SQLException e) {
//            System.out.println("Failed to create the database connection");
//        }
//        return null;
//    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
