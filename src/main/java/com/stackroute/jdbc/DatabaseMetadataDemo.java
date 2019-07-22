package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo {
    public void getDatabaseMetaData(){
        try{
            //Create and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Make a connection with the database
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
            //Retrive the meta data about the database
            DatabaseMetaData databaseMetaData=connection.getMetaData();

            System.out.println("Driver Name: "+databaseMetaData.getDriverName());
            System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());
            System.out.println("UserName: "+databaseMetaData.getUserName());
            System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());

            connection.close();
        }catch(ClassNotFoundException| SQLException e)
           {
               System.out.println(e);
           }
    }
}
