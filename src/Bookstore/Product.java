/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookstore;


/**
 *
 * @author sulli
 */
public abstract class Product implements Comparable<Product> {
    int productId;
    String title;
    String creator;
    double price;
    int amount;
    
    /**
     * default constructor for a product
     */
    Product(){
        
    }
    /**
     * constructor for a product 
     * used in subclasses
     * @param t
     * @param a
     * @param p 
     * @param ty
     * @param amnt
     */
    Product(int id,String t, String a, double p, int amnt){
        productId = id;
        title = t;
        creator = a;
        price = p;
        amount = amnt;
    }
    /**
     * getter method for title
     * @return 
     */
    public String getTitle(){
        return title;
    }
    //I'm not creating setter methods for product's title or creator
    /**
     * getter method for Creator
     * @return author
     */
    public String getCreator(){
        return creator;
    }
    /**
     * getter method for type
     * @return 
     */
    
    /**
     * getter method for price
     * @return 
     */
    public double getPrice(){
        return price;
    }
    /**
     * getter method for amount
     * @return 
     */
    public int getAmnt(){
        return amount;
    }    
    /**
     * setter method for amount
     * @param a 
     */
    public void setAmnt(int a){
        amount = a;
    }

    /**
     * print out info about the product
     */
    public abstract void asString();
    /**
     * getter for productID
     * @return 
     */       
    public int getProductId(){
        return this.productId;
    }
    /**
     * setter for ProductID
     * @param new productID
    */
    public void setProductId(int p){
        this.productId = p;
    }
    
    @Override
    public int compareTo(Product p){
        double OPrice = this.price;
        double NPrice = p.getPrice();
        if (OPrice > NPrice){
            return 1;
        }
        else if (NPrice > OPrice){
            return -1;
        }
        else{
            return 0;
        }
    }
}
