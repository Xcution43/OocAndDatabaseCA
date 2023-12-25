/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;

/**
 *
 * @author moogi
 */
public class User {
  
    //Creating objects
    /*
    username
    password
    userType
    firstName
    lastName
    userID
    */
    int userID;
    private String username;
    private String password;
    private String userType;
    private String firstName;
    private String lastName;
    private double totalIncome;
    private double paye;
    private double usc;
    private double prsi;
    private boolean isAdmin;
    
    
    //Making a constructor

    public User(int userID, String username, String password, String userType, String firstName, String lastName, double totalIncome, double paye, double usc, double prsi, boolean isAdmin) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalIncome = totalIncome;
        this.paye = paye;
        this.usc = usc;
        this.prsi = prsi;
        this.isAdmin = isAdmin;
    }
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getPaye() {
        return paye;
    }

    public double getUsc() {
        return usc;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }
    
    

    //Making Getters for everything and using encapsulation on them
    public double getPrsi() {
        return prsi;
    }

    //Making Getters for everything and using encapsulation on them

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setPaye(double paye) {
        this.paye = paye;
    }

    public void setUsc(double usc) {
        this.usc = usc;
    }

    public void setPrsi(double prsi) {
        this.prsi = prsi;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
