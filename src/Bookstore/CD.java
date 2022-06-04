/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookstore;

/**
 *
 * @author sulli
 */
public class CD extends Product{
    boolean isPlatinum;
    double hours;
    
    /**
     * constructor for CD object
     * @param id product id
     * @param t title
     * @param a creator/author
     * @param p price
     * @param amnt amount in stock
     * @param plat t if CD hit platinum
     * @param hrs number of hours in the album
     */
    public CD(int id, String t, String a, double p, int amnt,
            boolean plat, double hrs){
        super(id, t, a , p , amnt);
        this.isPlatinum = plat;
        this.hours = hrs;
        }
    /**
     * gettter for isPlatinum
     * @return 
     */
    public boolean getPlatinum(){
        return this.isPlatinum;
    }
    /**
     * setter for isPlatinum
     * @param P t if platinum
     */
    public void setPlatinum(boolean P){
        this.isPlatinum = P;
    }
    /**
     * getter for hours
     * @return hours 
     */
    public double getHours(){
        return this.hours;
    }
    /**
     * setter for hours
     * @param H number of hours in album
     */
    public void setHours(double H){
        this.hours = H;
    }
    
    @Override
    public void asString(){
        String s;
        if (this.isPlatinum){
            s = "Platinum Seller";
        }
        else{
            s = "Not Platinum";
        }
        System.out.println("\t" + this.productId + ". CD, "  + this.creator +
                ", $" + this.price + ", " + this.amount +
                " , " + s + ", " + this.hours + " hours long");
    }
}
