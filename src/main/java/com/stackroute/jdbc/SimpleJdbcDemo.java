package com.stackroute.jdbc;

import java.sql.*;

public class SimpleJdbcDemo {

//    private Connection connection;
//    private  Statement statement;
//    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*Load driver and register with DriverManager*/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+
                        " Age: "+resultSet.getInt(3)+ " Gender: "+resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

        }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*Load driver and register with DriverManager*/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+
                        " Age: "+resultSet.getInt(3)+ " Gender: "+resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*Load driver and register with DriverManager*/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {

            resultSet.afterLast();
            while (resultSet.previous() && resultSet.getRow()!=1) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+
                        " Age: "+resultSet.getInt(3)+ " Gender: "+resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*Load driver and register with DriverManager*/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
             PreparedStatement statement=connection.prepareStatement("select * from employee where name=? and gender=?");){
             statement.setString(1,name);
             statement.setString(2,gender);
             ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) +
                        " Age: " + resultSet.getInt(3) + " Gender: " + resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}