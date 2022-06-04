/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookstore;

import java.util.ArrayList;

/**
 *
 * @author sulli
 */
public class Cart {
    ArrayList<Product> MyCart = new ArrayList<>();
    
    /**
     * default constructor for Cart
     */
    Cart(){
        
    }
    /**
     * Getter method for cart
     * @return 
     */
    public ArrayList<Product> getCart(){
        return MyCart;
    }
    /**
    * Method for viewing total cost of cart
    * @return 
    */
    public double getTotal(){
        double total = 0;
        for (Product p: MyCart){
           double amnt = p.getAmnt();
           total = total + amnt * p.getPrice();
    }
        return total;
    }
    
    /**
     * Method for adding a product to cart
     * @param p
     * @param amnt 
     */
    public void AddToCart(Product p,int amnt){
        if (p instanceof Book){
            Book temp = new Book(p.getProductId(),p.getTitle(),p.getCreator(), p.getPrice(),amnt, ((Book)p).getBestSeller(), ((Book) p).getPages());
            MyCart.add(temp);
        }
        else if (p instanceof CD){
            CD temp = new CD(p.getProductId(),p.getTitle(),p.getCreator(), p.getPrice(),amnt, ((CD)p).getPlatinum(), ((CD) p).getHours());
            MyCart.add(temp);
        }
        else{
            DVD temp = new DVD(p.getProductId(),p.getTitle(),p.getCreator(), p.getPrice(),amnt, ((DVD)p).getGenre(), ((DVD) p).getScore());
            MyCart.add(temp);
        }
        
    }
    /**
     * Method for clearing cart
     */
    public void ClearCart(){
        MyCart.clear();
    }
}
