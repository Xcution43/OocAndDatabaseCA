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

/**
 *
 * @author ANUAN
 */
public class DatabaseWriter {
    public class DataWriter extends Database{
        
        
        public boolean addUser (User user) throws SQLException {
            try(
                    //DriverManager helps to manage our connection to the database
                    Connection conn=
                            DriverManager.getConnection(DB_URL, USER, PASSWORD);
                    //stmt is going to be sql queries
                    //we are going to call methods on he stmt and that is going to execute queries on the database
                    //we will use sql statements or sql queries in stmt here but we are going to run it in Java
                    //This is going to be pure sql but we are running it in Java
                Statement stmt = conn.createStatement();
                    ){
                String sql = String.format("INSERT INTO " + TABLE_NAME + "VALUES("
                // single quote are presequel because we are putting a text
                //%$ is string and %d is int
                + "'%s', '%s', '%s', '%s', '%s', %d);", user.getFirstName(), user.getLastName(), user.getPassword(), user.getUserType(), user.getUsername(), user.getUserID());
                        
               stmt.execute(sql);
               return true;
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        

            public boolean addAllUsers(List<User> userList) {
                return true;
            }
                
    }
}
                
                
                    
