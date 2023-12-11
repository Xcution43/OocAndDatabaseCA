package oocanddatabaseca;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ANUAN
 */
public class Login {
    
    String username = "ooc2023";
    String password = "ooc2023";
    Scanner scanner1;
    int count;
    
    public Login(Scanner scr) {
        scanner1 = scr;
    }

    public void setData(){
        System.out.println("Enter Username >");
        username = scanner1.next();
        System.out.println("Enter Password >");
        password = scanner1.next();
        loginPage();
       // public void setName(String name) {
       // this.name = name;
    }
    
    public void againPass() {
        System.out.println("Enter Password again >");
        password = scanner1.next();
        loginPage();
    }
    
    public void loginPage(){
        if(username.equals("admin")){
            if(password.equals("admin")){
                Welcome w1 = new Welcome();
            } else {
                count++;
                System.out.println("Incorrect password!");
                if(count < 3){
                    againPass();
                } else {
                    System.out.println("Program locked!");
                }
                
            }
        } else {
            count++;
            System.out.println("Incorrect username!");
            if(count < 3){
                setData();
            } else {
                System.out.println("Program locked!");
            }
        }
    } 
    
    
    
}
