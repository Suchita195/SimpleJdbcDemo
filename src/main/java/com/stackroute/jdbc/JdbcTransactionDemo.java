package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTransactionDemo {
    public void getTransactionDemo(){
        try{
            //register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
            //Set autocommit as false
            connection.setAutoCommit(false);
            //Create a prepared Statement with parameterised query
            PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?)");
            //For taking the data from user
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

                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setInt(3,age);
                preparedStatement.setString(4,gender);

                preparedStatement.executeUpdate();

                System.out.println("commit/rollback");
                String answer=bufferedReader.readLine();
                if(answer.equals("commit")){
                    connection.commit();
                }
                if(answer.equals("rollback")){
                    connection.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans=bufferedReader.readLine();
                if(ans.equals("n")){
                    break;
                }

            }
            connection.commit();
            System.out.println("record successfully saved");

            connection.close();//before closing connection commit() is called
        }catch(Exception e){System.out.println(e);}

    }}
