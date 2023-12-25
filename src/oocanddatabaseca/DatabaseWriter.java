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
        try (
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        Statement stmt = conn.createStatement()){
            for (User user : userList) {
                String sql = String.format("INSERT INTO " + TABLE_NAME + " VALUES ("
                + "'%s', '%s', '%s', '%s', '%s', %d, %d, %d, ,%d ,%d);",
                user.getUsername(), user.getPassword(), user.getUserType(), user.getFirstName(), user.getLastName(), user.getUserID(), user.getTotalIncome(), user.getPaye(), user.getUsc(), user.getPrsi());
            stmt.execute(sql);
            }
            return true;
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
        
               
                
                
                    
