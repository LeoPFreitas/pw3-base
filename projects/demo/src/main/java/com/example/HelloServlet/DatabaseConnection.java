package com.example.HelloServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        //Informação para a conexão
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";

        //Nome e dados da Database
        String dbName = "enderecos";
        String dbUsername = "root";
        String dbPassword = "password";

        //busca o driver e realiza a conexão
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);

        return con;

    }
}

