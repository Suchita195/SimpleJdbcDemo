package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getResultSetMetaData(){
        try{
            //Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Make the connection with the database
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
            //Create Prepared Statement
            PreparedStatement preparedStatement=connection.prepareStatement("select * from employee");
            ResultSet resultSet=preparedStatement.executeQuery();
            //Retrieve meta data about the result set
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

            System.out.println("Total columns: "+resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 2nd column: "+resultSetMetaData.getColumnName(2));
            System.out.println("Column Type Name of 2nd column: "+resultSetMetaData.getColumnTypeName(2));

            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
