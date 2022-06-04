/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookstore;

/**
 *
 * @author sulli
 */
public class Book extends Product {
    int Pages;
    boolean isBestSeller;
    
    /**
     * Constructor for Book
     * @param id ProductId
     * @param t Title
     * @param a Author/Creator
     * @param p Double
     * @param amnt
     * @param best
     * @param page
     */
    public Book(int id, String t, String a, double p, int amnt,
            boolean best, int page){
        super(id, t, a , p , amnt);
        this.Pages = page;
        this.isBestSeller = best;
    }
    /**
     * getter for best seller
     * @return 
     */
    public boolean getBestSeller(){
        return this.isBestSeller;
    }
    /**
     * setter for Best Seller
     * @param b 
     */
    public void setBestSeller(boolean b){
        this.isBestSeller = b;
    }
    /**
     * getter for Pages
     * @return 
     */
    public int getPages(){
        return this.Pages;
    }
    /**
     * setter for Pages
     * @param p 
     */
    public void setPages(int p){
        this.Pages = p;
    }
    @Override
    public void asString(){
        String s;
        if (this.isBestSeller){
            s = "Best Seller";
        }
        else{
            s = "Not Best Seller";
        }
        System.out.println("\t" + this.productId + ". Book, " + this.creator +
                ",  $" + this.price + ", " + this.amount +
                " , " + s + ", " + this.Pages + " pages long");
    }
   
}
