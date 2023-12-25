/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocanddatabaseca;

/**
 *
 * @author temuu
 */
public abstract class Database {
    
    //We made it static because we do not need setupDB object
    //It can run from this class
    //Since it is abstract class we made them protected
    
    protected final static String DB_BASE_URL = "jdbc:mysql://localhost";
    protected final static String USER = "ooc2023"; 
    protected final static String PASSWORD = "ooc2023";
    protected final static String DB_NAME = "oocdb";
    protected final static String TABLE_NAME = "userData";
    
    //jdbc:msql://localhost/ooc_database_assessment  / forward slash connects base url to userdata 
    
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
}
    

