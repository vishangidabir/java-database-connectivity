package com.bridgelabz;

import java.sql.*;

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
            Statement statement = connection.createStatement();
            statement.execute("update payroll_service.employee_details set salary = 300000 where  name = 'Jitesh'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM payroll_service.employee_details");
            System.out.println("Update employee data from database :");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getDouble("salary") + " " + resultSet.getDate("start"));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}
