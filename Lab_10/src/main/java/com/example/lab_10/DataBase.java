package com.example.lab_10;

import java.sql.*;

public class DataBase {
    private Connection connection;

    public Connection  connection(){
        if(connection != null)
            return connection;

        try {
            Class.forName("org.mariadb.jdbc.Driver").getDeclaredConstructor().newInstance();
             connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/university?user=root&password=9I50ybkubu");

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        return connection;
    }
}
