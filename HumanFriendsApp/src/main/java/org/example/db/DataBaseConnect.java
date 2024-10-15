package org.example.db;

import java.sql.*;

public class DataBaseConnect {
    private static final String user = System.getenv("MYSQL_USER");
    private static final String password = System.getenv("MYSQL_PASSWORD");
    private static final String host = System.getenv("MYSQL_HOST");
    private static final String port = System.getenv("MYSQL_PORT");


    private static final String db_url = "jdbc:mysql://" + host + ":" + port + "/human_friends";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(db_url, user, password);
    }
}
