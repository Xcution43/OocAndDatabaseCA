/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocanddatabaseca;

/**
 *
 * @author moogi
 */
public class OocAndDatabaseCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        User u1 = new User("CCT", "Dublin", "Admin", "Munkhtemuulen", "Gantulga");
        User u2 = new User("OOC", "Ireland", "Regular user", "Temuulen", "Narankhuu");
        
        System.out.println(u1.getUserID());
        System.out.println(u2.getUserID());
        
        System.out.println(User.getCurrentID());
        
    }
    
}
