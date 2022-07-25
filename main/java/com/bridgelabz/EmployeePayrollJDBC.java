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
            statement.execute("insert into payroll_service.employee_details values(4,'Sanket','M',250000,'2018-05-21')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM payroll_service.employee_details");
            System.out.println("Update employee data from database :");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3)
                        + " " + resultSet.getDouble(4)
                        + " " + resultSet.getDate(5));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}