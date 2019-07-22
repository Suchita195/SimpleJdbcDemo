package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {
    public void getRowSet(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

            //Creating and Executing RowSet
        try(
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();){
            rowSet.setUrl("jdbc:mysql://localhost:3306/employeeDb");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from employee");
            rowSet.execute();

            while (rowSet.next()) {
                // Generating cursor Moved event
                System.out.println("Id: " + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Age: " + rowSet.getInt(3));
                System.out.println("Gender: " + rowSet.getString(4));
            }
        }
        catch(Exception e)
            {
                System.out.println(e);
            }

        }

    }
