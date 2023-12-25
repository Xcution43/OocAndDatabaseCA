/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author moogi
 */
public class RegularUser extends User{
    
    public RegularUser(int userID, String username, String password, String userType, String firstName, String lastName, double totalIncome, double paye, double usc, double prsi, boolean isAdmin) {
        super(userID, username, password, userType, firstName, lastName, totalIncome, paye, usc, prsi, isAdmin);
    }

}

