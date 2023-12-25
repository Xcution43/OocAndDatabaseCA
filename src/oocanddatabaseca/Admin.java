/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moogi
 */
public class Admin extends User {
    
    public Admin(int userID, String username, String password, String userType, String firstName, String lastName, double totalIncome, double paye, double usc, double prsi, boolean isAdmin) {
        super(userID, username, password, userType, firstName, lastName, totalIncome, paye, usc, prsi, isAdmin);
    }
        public void modifyProfile(String newFirstName, String newLastName) {
        setFirstName(newFirstName);
        setLastName(newLastName);
    }
    
    public void getAllUsers() {
        DatabaseReader dbr = new DatabaseReader();
        dbr.getAllData();
    }
    
    public boolean deleteUser(User userToDelete) throws SQLException {
        DatabaseWriter dbw = new DatabaseWriter();
        return dbw.deleteUser(userToDelete.getUserID());
    }

}
