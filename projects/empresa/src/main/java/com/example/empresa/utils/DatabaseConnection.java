package com.example.empresa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeConnection() throws ClassNotFoundException, SQLException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "empresa";
        String dbUsername = "root";
        String dbPassword = "password";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbUrl + dbName, dbUsername, dbPassword);
    }

}
