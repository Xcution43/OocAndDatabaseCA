/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ANUAN
 */
public class DatabaseSetup {
    
    //The reason why we made it static is we do not need setupDB object
    //we just need to run it from this class
    final static String DB_BASE_URL = "jdbc:mysql://localhost";
    final static String USER = "ooc2023";
    final static String PASSWORD = "ooc2023";

    //
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        try (
                
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
            
            //DriverManager helps to manage our connection to the database                
                
                //stmt is going to be sql queries
                //we are gonna call methods on the stmt and that is gonna execute queries on the database
                //we are gonna use sql statements or sql queries in stmt here but we are gonna run that in Java
                //this is gonna be pure sql but we are running it in Java                
                Statement stmt = conn.createStatement();
                
                ){
                //writing and creating sql queries
                //this creates sql database named oocdb
                
                stmt.execute("CREATE DATABASE IF NOT EXISTS oocdb;");
                stmt.execute("USE oocdb");
                
                    //this is gonna contain our sql codes
                    String sql = "CREATE TABLE IF NOT EXISTS userData ("
                            
                            /*
                            username
                            password
                            userType
                            firstName
                            lastName
                            userID
                            */
                            
                            //Here we are gonna specify all the column names and the data type that is gonna be in that column
                            + "username VARCHAR(255),"
                            + "password VARCHAR(255),"
                            + "userType VARCHAR(50),"
                            + "firstName VARCHAR (50),"
                            + "lastName VARCHAR(50),"
                            + "userID INT(10)"
                            + ");";
                        stmt.execute(sql);
                        //Here we are checking errors in database
                        //If there is an error, we can see what's going on and program will not use database
                        
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
 
    }
    
}
