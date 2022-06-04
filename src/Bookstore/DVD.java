/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookstore;

/**
 *
 * @author sulli
 */
public class DVD extends Product{
    int Score;
    String genre;    
    
    public DVD(int id, String t, String a, double p, int amnt,
            String gen, int score){
        super(id, t, a , p , amnt);
        this.Score = score;
        this.genre = gen;
    }
    /**
     * getter for score
     * @return 
     */
    public int getScore(){
        return this.Score;
    }
    public void setScore(int s){
        this.Score = s;
    }
    /**
     * getter for Genre
     * @return 
     */
    public String getGenre(){
        return this.genre;
    }
    /**
     * setter for Genre
     * @param s 
     */
    public void setGenre(String s){
        this.genre = s;
    }
    @Override
    public void asString(){       
        System.out.println("\t" + this.productId + ". DVD, " + this.creator +
                ", $" + this.price + ", " + this.amount +
                " , 3" + this.genre + ", " + this.Score + " on Rotten Tomatoes");
    }
}
