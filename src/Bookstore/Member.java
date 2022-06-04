/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookstore;

/**
 *
 * @author sulli
 */
public class Member {
    String user;
    String password;
    Boolean premium;
    double running_total;
    /**
     * default constructor for member
     */
    Member(){
      
    }
    /**
     * Constructor for a member object
     * @param u - username
     * @param p - password
     * @param prem - true if membership is premium
     */
    Member(String u, String p, Boolean prem){
        user = u;
        password = p;
        premium = prem;
        running_total = 0;
    }
    /**
     * Constructor for a member object
     * @param u - username
     * @param p - password
     * @param prem - true if membership is premium
     * @param run - running total
     */
    Member(String u, String p, Boolean prem, double run){
        user = u;
        password = p;
        premium = prem;
        running_total = run;
    }
    /**
     * getter method for user field
     * @return username
     */
    public String getUser(){
        return user;
    }
    /**
     * setter method for user field
     * @param u 
     */
    public void setUser(String u){
        user = u;
    }
    /**
     * getter method for password field
     * @return password
     */
    public String getPass(){
        return password;
    }
    /**
     * setter method for password field
     * @param p replacement password
     */
    public void setPass(String p){
        password = p;
    }
    /**
     * getter method for premium field
     * @return true if member is a premium member
     */
    public boolean isPremium(){
        return premium;
    }
    /**
     * setter method for premium field
     * @param prem true for premium membership
     */
    public void setPremium(boolean prem){
        premium = prem;
    }
    /**
     * method for getting running total
     * @return 
     */
    public double getTotal(){
        return running_total;
    }
    /**
     * Method for adding to running total
     * @param t 
     */
    public void addTotal(double t){
        running_total = running_total + t;
    }
}
