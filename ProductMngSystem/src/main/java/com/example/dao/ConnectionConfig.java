package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    private static Connection connection;

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "postgres";
        String password = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver not found!", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database!", e);
        }
        return connection;
    }
}
