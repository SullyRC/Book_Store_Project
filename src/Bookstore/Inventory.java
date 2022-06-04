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
public class Inventory implements BookstoreSpecification {
    ArrayList<Product> ProductList = new ArrayList<>();
    /**
    * default constructor for an inventory object
    */
    int increment = 0;
    /**
     * increments increment to be used for making product ids
     * @return to be product ID
     */
    public int addIncrement(){
        this.increment = this.increment + 1;
        return this.increment;
    }
    
    Inventory(){
             
    }
    /**
     * method for adding a product to inventory
     * @param p 
     */
    public void addProduct(Product p){
        ProductList.add(p);
    }
    
    /**
     * getter method for ProductList
     * @return 
     */
    public ArrayList<Product> getProductList(){
        return ProductList;
    }
    
    // The following methods are important for adding to cart and removing from inventory
    /**
     * Method for removing an object or its count from the inventory
     * @param p
     * @param amnt 
     * @return true if value is reduced or false if amnt is too much
     */
    public boolean RemoveFromInventory(Product p, int amnt){
        if (p.getAmnt() >= amnt){
            p.setAmnt(p.getAmnt() - amnt);
            return true;
        }
        else {
            return false;
        }
    }       
    /**
     * Method for getting length of inventory
     * @return 
     */
    public int getInventoryLen(){
        return ProductList.size();
    }
  
    @Override
    public int restockProduct(int productId, int amount){
        for (Product p: ProductList){
            if (productId == p.getProductId()){
                p.setAmnt(amount + p.getAmnt());
                return amount;
            }
        }
        return 0;
    }
    
    public double inventoryValue(){
        double val = 0;
        for (Product p: ProductList){
            val = val + p.getPrice() * p.getAmnt();
        }
        return val;
    }
}
