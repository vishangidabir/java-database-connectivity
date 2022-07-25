package com.bridgelabz;

import java.sql.*;
import java.util.Scanner;

public class EmployeePayrollJDBC {

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
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into employee_details values (5,'Vihan','M','2019-05-13',300000, 2000, 50000, 4000000, 4000)");
            ResultSet resultSet = statement.executeQuery("select * from employee_details");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3)
                        + " " + resultSet.getDate(4)
                        + " " + resultSet.getDouble(5)
                        + " " + resultSet.getDouble(6)
                        + " " + resultSet.getDouble(7)
                        + " " + resultSet.getDouble(8)
                        + " " + resultSet.getDouble(9));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}