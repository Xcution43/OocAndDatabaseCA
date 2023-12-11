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

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int aCurrentID) {
        currentID = aCurrentID;
    }
   
    //Creating objects
    /*
    username
    password
    userType
    firstName
    lastName
    userID
    */
    
    private String username;
    private String password;
    private String userType;
    private String firstName;
    private String lastName;
    private int userID;
    //currentID is going to be shared any object in this class
    private static int currentID = 1;
    
    
    //Making a constructor
    public User(String username, String password, String userType, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        //This will automatically give ID whenever we make new user
        this.userID = currentID;
        //Testing the user class
        System.out.println("This user's full name is: " +firstName + " " + lastName + " and this user's type is: " + userType);
        currentID++;
    }
    
    //Making Getters for everything and using encapsulation on them
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

    public int getUserID() {
        return userID;
    }
     
     
    //Making Getters for everything and using encapsulation on them
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

    public void setUserID(int userID) {
        this.userID = userID;
    }   
    
}
