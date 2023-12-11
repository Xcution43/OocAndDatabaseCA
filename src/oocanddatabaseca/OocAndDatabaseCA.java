/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocanddatabaseca;

import java.sql.SQLException;
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
        
        
            Scanner scr = new Scanner (System.in);
            
            Login login = new Login(scr);
            login.setData();

        //Testing how the user class and currentID works
//        User u1 = new User("CCT", "Dublin", "Admin", "Munkhtemuulen", "Gantulga");
//        User u2 = new User("OOC", "Ireland", "Regular user", "Temuulen", "Narankhuu");
//        
//        System.out.println(u1.getUserID());
//        System.out.println(u2.getUserID());
//        
//        System.out.println(User.getCurrentID());
//        
//        
//        //Here we are checking whether our database is connected or not
//        if (DatabaseSetup.setupDB()) {
//            System.out.println("Database and tables are created");
//        } else {
//            System.out.println("Oops! There was a database creation problem ...");
//        }
    }
    
    
}
