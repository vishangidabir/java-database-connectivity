package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
    
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3307/payroll_service?useSSL=false";
        String userName = "root";
        String passWord = "1234";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.D river");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("Cannot find the driver in the classpath", exception);
        }
        listDrivers();
        try {
            System.out.println("Connecting to database :" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, passWord);
            System.out.println("Connection is successful!!!!" + connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while ((driverList.hasMoreElements())) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
