/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocanddatabaseca;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author moogi
 */
public class OocAndDatabaseCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        
//        Scanner scr = new Scanner (System.in);
//            
//        Login login = new Login(scr);
//        login.setData();
     
        //Here we are checking whether our database is connected or not
        if (DatabaseSetup.setupDB()) {
            System.out.println("Database and tables are created");
        } else {
            System.out.println("Oops! There was a database creation problem ...");
        }


        //Adding users in the database table
        List<User> userToAdd = new ArrayList<>();

        userToAdd.add(new User(1, "CCT", "Dublin", "admin", "Munkhtemuulen", "Gantulga", 52970, 12788, 1423, 52970));
        userToAdd.add(new User(2, "mutafeke", "gunj", "regular user", "Temuulen", "Narankhuu", 49500, 10328, 1220, 49500));
        userToAdd.add(new User(3, "Lolzmaa", "lol255", "regular user", "Alex", "Harvey", 51856, 11258, 1340, 51856));
        userToAdd.add(new User(4, "twentyone", "savage", "regular user", "John", "Doe", 38952, 8564, 989, 38952));
        userToAdd.add(new User(5, "Lambo", "shaayoo", "regular user", "Burna", "Boy", 39700, 8790, 1050, 39700));
        userToAdd.add(new User(6, "Epic", "goat", "regular user", "Chris", "Judge", 47233, 11200, 1244, 47233));
        
        DatabaseWriter dbw = new DatabaseWriter();
        boolean successfulAdd = dbw.addAllUser(userToAdd);
        
        if (successfulAdd) {
            System.out.println("Users are successfully added to the database!");
        } else {
            System.out.println("Oops! Error occurred. Users adding process has been failed!");
        }
    }
    
    
}
