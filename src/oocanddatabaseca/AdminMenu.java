/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author temuu
 */
public class AdminMenu {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Assume the database is already set upo and users are added
        DatabaseSetup.setupDB();
        
        //Admin login (you can enhace this with better authentication)
        Admin admin = login();
        
        if(admin!= null){
            System.out.println("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "!");
            displayMenu(admin);
        }else{
            System.out.println("Invalid credentials, Existing..");
        }
    }
    private static Admin login(){
        System.out.println("Admin Login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        //Implement authentication logic(you can enhance this)
    Admin admin = authenticateAdmin(username, password);
    
return admin;
    }
    
private static Admin authenticateAdmin(String username, String password){
    //Implement logic to authenticate admin from the database
    // You might want to queary the database to get admin details
    //For simplicity, let us assume there is only one admin with username "CCT" and password "Dublin"
    if ("CCT".equals(username) && "Dublin".equals(password)){
        //Fetch admin details from the data base if needed 
        return new Admin (1, username, password, "admin", "Munkhtemuulen", "Gantulga" , 52970, 12788, 1423, 52970, true);    
    }else{
        return null;
    }
}

private static void displayMenu(Admin admin) throws SQLException{
    while(true) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Modify Profile");
        System.out.println("2. View All Users");
        System.out.println("3. Remove User");
        System.out.println("4. Review User Operations");
        System.out.println("5. Exit");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                modifyProfile(admin);
                break;
            case 2:
                viewAllUsers();
                break;
            case 3:
                removeUser();
                break;
            case 4:
                reviewUserOperations();
                break;
            case 5:
                System.out.println("Exiting Admin Menu. Goodbye!");
                
        System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

private static void modifyProfile(Admin admin){
    System.out.print("Enter new first name");
    String newFirstName = scanner.nextLine();
    System.out.print("Enter your last name");
    String newLastName = scanner.nextLine();
    
    admin.modifyProfile(newFirstName, newLastName);
    System.out.println("Profile modified successfully");
}

private static void viewAllUsers() throws SQLException {
    DatabaseReader databaseReader = new DatabaseReader();
    List<User> users = databaseReader.getAllUsers();
    
    System.out.println("\nAll Users:");
    for (User user: users){
        System.out.println(user.getUsername());
    }
 }

private static void removeUser() throws SQLException{
    DatabaseReader databaseReader = new DatabaseReader();
    List<User> users = databaseReader.getAllUsers();
    
    System.out.println("\nSelect a user to remove:");
    for (int i = 0; i <users.size(); i++) {
        System.out.println((i + 1) + ". " + users.get(i).getUsername());
    }

int choice = getIntInput("Enter the number of the user to remove:");
if (choice > 0 && choice <=users.size()){
    Admin admin = new Admin(1, "CCT", "Dublin", "admin", "Munkhtemuulen", "Gantulga", 52970, 12788, 1423, 52970, true);
    boolean removed = admin.removeUser(users.get(choice - 1));

    if(removed){
        System.out.println("User removed successfully");
    }else{
        System.out.println("Failed to remove user.");
    }
    }else{
        System.out.println("Invalid choice. Please try again.");
    }
}

private static void reviewUserOperations(){
    //Implement logic to review user operations(if needed)
    System.out.println("Reviewing user operaions..");
}

private static int getIntInput(String prompt){
    int input = -1;
    boolean validInput = false;
    
    while (!validInput){
        try{
            System.out.print(prompt);
            input = scanner.nextInt();
            validInput = true;
        } catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            //Clear the input buffer
        }
    }
    
scanner.nextLine();
//Consume the newline character 
return input;
    }
}
