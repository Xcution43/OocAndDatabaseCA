/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocanddatabaseca;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        // Here we are checking whether our database is connected or not
        if (DatabaseSetup.setupDB()) {
            System.out.println("Database and tables are created");
        } else {
            System.out.println("Oops! There was a database creation problem ...");
        }

        // Admin login (you can enhance this with better authentication)
        Admin admin = login();

        if (admin != null) {
            System.out.println("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "!");
            displayMenu(admin);
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private static Admin login() {
        System.out.println("Admin Login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Implement authentication logic(you can enhance this)
        Admin admin = authenticateAdmin(username, password);

        return admin;
    }

    private static Admin authenticateAdmin(String username, String password) {
        // Implement logic to authenticate admin from the database
        // You might want to query the database to get admin details
        // For simplicity, let us assume there is only one admin with username "CCT" and password "Dublin"
        if ("CCT".equals(username) && "Dublin".equals(password)) {
            // Fetch admin details from the database if needed
            return new Admin(1, username, password, "admin", "Munkhtemuulen", "Gantulga", 52970, 12788, 1423, 52970, true);
        } else {
            return null;
        }
    }

    private static void displayMenu(Admin admin) throws SQLException {
        while (true) {
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

    private static void modifyProfile(Admin admin) {
        System.out.print("Enter new first name: ");
        String newFirstName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String newLastName = scanner.nextLine();

        admin.modifyProfile(newFirstName, newLastName);
        System.out.println("Profile modified successfully");
    }

    private static void viewAllUsers() throws SQLException {
        DatabaseReader databaseReader = new DatabaseReader();
        List<User> users = databaseReader.getAllData();

        System.out.println("\nAll Users:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    private static void removeUser() throws SQLException {
        DatabaseReader databaseReader = new DatabaseReader();
        List<User> users = databaseReader.getAllData();

        System.out.println("\nSelect a user to remove:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getUsername());
        }

        int choice = getIntInput("Enter the number of the user to remove:");
        if (choice > 0 && choice <= users.size()) {
            Admin admin = new Admin(1, "CCT", "Dublin", "admin", "Munkhtemuulen", "Gantulga", 52970, 12788, 1423, 52970, true);
            boolean removed = admin.deleteUser(users.get(choice - 1));

            if (removed) {
                System.out.println("User removed successfully");
            } else {
                System.out.println("Failed to remove user.");
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void reviewUserOperations() {
        // Implement logic to review user operations (if needed)
        System.out.println("Reviewing user operations...");
    }

    private static int getIntInput(String prompt) {
        int input = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.nextLine(); // Consume the newline character
        return input;
    }
}    
        
        
     
        //Here we are checking whether our database is connected or not
//        if (DatabaseSetup.setupDB()) {
//            System.out.println("Database and tables are created");
//        } else {
//            System.out.println("Oops! There was a database creation problem ...");
//        }


        //Adding users in the database table
//        List<User> userToAdd = new ArrayList<>();
//
//        userToAdd.add(new User(1, "CCT", "Dublin", "admin", "Munkhtemuulen", "Gantulga", 52970, 12788, 1423, 52970, true));
//        userToAdd.add(new User(2, "mutafeke", "gunj", "regular user", "Temuulen", "Narankhuu", 49500, 10328, 1220, 49500, false));
//        userToAdd.add(new User(3, "Lolzmaa", "lol255", "regular user", "Alex", "Harvey", 51856, 11258, 1340, 51856, false));
//        userToAdd.add(new User(4, "twentyone", "savage", "regular user", "John", "Doe", 38952, 8564, 989, 38952, false));
//        userToAdd.add(new User(5, "Lambo", "shaayoo", "regular user", "Burna", "Boy", 39700, 8790, 1050, 39700, false));
//        userToAdd.add(new User(6, "Epic", "goat", "regular user", "Chris", "Judge", 47233, 11200, 1244, 47233, false));
//        
//        DatabaseWriter dbw = new DatabaseWriter();
//        boolean successfulAdd = dbw.addAllUser(userToAdd);
//        
//        if (successfulAdd) {
//            System.out.println("Users are successfully added to the database!");
//        } else {
//            System.out.println("Oops! Error occurred. Users adding process has been failed!");
//        }
    
    
