package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcBatchDemo {
    public void getBatchDemo(){
        try{
            //Create and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Make a conection with the database
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
            //Create Prepared Statement
            PreparedStatement prepareStatement=connection.prepareStatement("insert into employee values(?,?,?,?)");

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            while(true){

                System.out.println("enter id");
                String s1=bufferedReader.readLine();
                int id=Integer.parseInt(s1);

                System.out.println("enter name");
                String name=bufferedReader.readLine();

                System.out.println("enter age");
                String s3=bufferedReader.readLine();
                int age=Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender=bufferedReader.readLine();

                prepareStatement.setInt(1,id);
                prepareStatement.setString(2,name);
                prepareStatement.setInt(3,age);
                prepareStatement.setString(4,gender);

                prepareStatement.addBatch();
                System.out.println("Want to add more records y/n");
                String answer=bufferedReader.readLine();
                if(answer.equals("n")){
                    break;
                }

            }
            prepareStatement.executeBatch();

            System.out.println("record successfully saved");

            connection.close();
        }catch(Exception e){System.out.println(e);}

    }}
