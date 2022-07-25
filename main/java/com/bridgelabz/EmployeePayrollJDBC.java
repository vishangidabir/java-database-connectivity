package com.bridgelabz;

import java.sql.*;
import java.util.Scanner;

public class EmployeePayrollJDBC {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~Welcome to Employee Payroll program on JDBC~~~~~");

        System.out.println("\nChoose option \n1 : Sum \n2 : Average \n3 : Minimum \n4 : Maximum \n5 : Count ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                connectDB("select sum(salary) from payroll_service.employee_details where gender = 'F' group by gender");
                break;
            case 2:
                connectDB("select avg(salary) from payroll_service.employee_details where gender = 'F' group by gender");
                break;
            case 3:
                connectDB("select min(salary) from payroll_service.employee_details where gender = 'F' group by gender");
                break;
            case 4:
                connectDB("select max(salary) from payroll_service.employee_details where gender = 'F' group by gender");
                break;
            case 5:
                connectDB("select count(salary) from payroll_service.employee_details where gender = 'F' group by gender");
                break;
            default:
                System.out.println("Invalid Input ! Please enter valid input !");
        }
    }

    private static void connectDB(String string) throws Exception {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/payroll_service", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(string);
            System.out.println("Connection is successful!!!!");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}