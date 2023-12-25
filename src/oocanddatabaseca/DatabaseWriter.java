/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;

import static oocanddatabaseca.Database.PASSWORD;
import static oocanddatabaseca.Database.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ANUAN
 */
public class DatabaseWriter extends Database {
    
    
    //establishing connection with database and add users
public boolean addAllUser(List<User> userList) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
        // Using PreparedStatement for parameterized queries
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (User user : userList) {
                //Setting parameter values for each user
                stmt.setInt(1, user.getUserID());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getUserType());
                stmt.setString(5, user.getFirstName());
                stmt.setString(6, user.getLastName());
                stmt.setDouble(7, user.getTotalIncome());
                stmt.setDouble(8, user.getPaye());
                stmt.setDouble(9, user.getUsc());
                stmt.setDouble(10, user.getPrsi());

                stmt.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    //establishing connection with database and delete users by userID
    public boolean deleteUser(int userID) throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            String sql = String.format("DELETE FROM " + TABLE_NAME + " WHERE userID = %d;", userID);
            int rowsAffected = stmt.executeUpdate(sql);
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateUser(int userID, String newUsername, String newPassword, int newUserID) throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
           String sql = String.format("UPDATE " + TABLE_NAME + " SET "
           + "username = '%s', password = '%s', userID = %d "
           + "WHERE userID = %d;",
           newUsername, newPassword, newUserID, userID);
           int rowsAffected = stmt.executeUpdate(sql);
           
           return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
        
               
                
                
                    
