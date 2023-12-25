/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;

import static oocanddatabaseca.Database.DB_URL;
import static oocanddatabaseca.Database.PASSWORD;
import static oocanddatabaseca.Database.TABLE_NAME;
import static oocanddatabaseca.Database.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moogi
 */
public class DatabaseReader {
    public void getAllData() {
        try (
            //DriverManager helps to manage our connection to the database                
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                             
            Statement stmt = conn.createStatement();
                
            //Here we are reading from our database. We are getting results and it is going to be i its own format that is called ResultSet
            //We use this ResultSet object in order to parse our different results
            //The output of stmt.executeQuery(String.format(); is our results
            //Basically, object that stores the results of our query
            ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s;",
                    TABLE_NAME));
        ){
            while (results.next()) {
            //results is a cursor/pointer to a particular row in the results
            //once we are on the row we want, we can extract the data based on the column name
            //Selects row 1. Need to put following code once in order to get first row
            System.out.println(results.getString("username"));
            System.out.println(results.getInt("userID"));
        }    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public User getUserData(int userID) throws SQLException {
        try (
             //DriverManager helps to manage our connection to the database                
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             
             Statement stmt = conn.createStatement();
                    
             ResultSet results = stmt.executeQuery(String.format(
                // %s stands for String whereas %d stands for Digit which means Integer
                "SELECT * FROM %s WHERE id=%d;",
                TABLE_NAME, userID));
                ){
        if (results.next()) {
            
        //Use the data from the database to create User object /using getAllData/
        int userIDforReader = results.getInt("userID");
        String username = results.getString("username");
        String password = results.getString("password");
        String userType = results.getString("userType");
        String firstname = results.getString("firstname");
        String lastname = results.getString("lastname");
        double totalIncome = results.getDouble("total_income");
        double paye = results.getDouble("paye");
        double usc = results.getDouble("usc");
        double prsi = results.getDouble("prsi");
        boolean isAdmin = results.getBoolean("isAdmin");
        
        User user = new User (userIDforReader, username, password, userType, firstname, lastname, totalIncome, paye, usc, prsi, isAdmin);
        return user;
        } else { 
            System.out.println("User not Found" + userID);
            return null;
        }       
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
}
