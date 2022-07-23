package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo {

    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3307/payroll_service?useSSL=false";
        String userName = "root";
        String passWord = "1234";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            System.out.println("Connecting to database :" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, passWord);
            System.out.println("Connection is successful!!!!" + connection);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}
