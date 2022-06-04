/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Bookstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;


/**
 *
 * @author sulli
 */
public class Bookstore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       //member list acts as our database for all of our users
       //This would be stored externally but for this project I'll just make it an arraylist
       ArrayList<Member> memberlist = new ArrayList<>();
       ArrayList<Product> tempList = new ArrayList<>();
       int newMembers = 0;
       Inventory stock = new Inventory();
       try{
           Scanner file_scanner = new Scanner(new File("Inventory.txt"));
           String line;
           String[] list;
           while (file_scanner.hasNext()){
              line = file_scanner.nextLine();
              list = line.split(",");
              if (list[0].equals("Book")){
                  stock.addProduct(new Book(stock.addIncrement(),list[1],list[2],Double.parseDouble(list[3]),
                          Integer.parseInt(list[4]),Boolean.parseBoolean(list[5]),Integer.parseInt(list[6])));
              }
              else if (list[0].equals("CD")){
                  stock.addProduct(new CD(stock.addIncrement(),list[1],list[2],Double.parseDouble(list[3]),
                          Integer.parseInt(list[4]),Boolean.parseBoolean(list[5]),Double.parseDouble(list[6])));
              }
              else if (list[0].equals("DVD")){
                  stock.addProduct(new DVD(stock.addIncrement(),list[1],list[2],Double.parseDouble(list[3]),
                          Integer.parseInt(list[4]),list[5],Integer.parseInt(list[6])));
              
                }
              else {
                  
              }
       }
           file_scanner.close();
       }
       catch (FileNotFoundException e){
           System.out.println("Inventory file not found in directory");
       }
       
       try{
           Scanner file_scanner2 = new Scanner(new File("MemberList.txt"));
           String line;
           String[] list;
           while (file_scanner2.hasNext()){
               line = file_scanner2.nextLine();
               list = line.split(",");
               memberlist.add(new Member(list[0],list[1],Boolean.parseBoolean(list[2]),
                       Double.parseDouble(list[3])));
           }
       }
       catch (FileNotFoundException e){
           System.out.println("Member list file not found in directory");
       }
       Cart report = new Cart();
       Cart myCart = new Cart();
       Member account = new Member();
       //Loop for the entire interface
       loop: while(true){
           System.out.println("Please select an option from below");
           System.out.println("\t 0. Exit");
           System.out.println("\t 1. Go shopping");
           System.out.println("\t 2. Check out");
           System.out.println("\t 3. Sign into account");
           System.out.println("\t 4. Create account");
           System.out.println("\t 5. Check account running total");
           System.out.println("\t 6. Restock inventory");
           System.out.println("\t 7. View cost of all inventory");
           System.out.println("\t 8. View inventory by price");
           
           Scanner sc = new Scanner(System.in);
           try {int num = sc.nextInt();
           
           switch (num){
               // case for exiting system
               case 0:
                   System.out.println("Thank you for shopping with us!");
                   try {
                       FileOutputStream fs = new FileOutputStream("Inventory2.txt");
                       PrintWriter outFS = new PrintWriter(fs);
                       for (Product p: stock.getProductList()){
                           if (p instanceof Book){
                               
                               outFS.println("Book," + p.getTitle() + "," + p.getCreator() +"," +
                                       p.getPrice() + "," + p.getAmnt() + "," + ((Book)p).getBestSeller()
                               + "," + ((Book)p).getPages());
                           }
                           else if (p instanceof DVD){
                               outFS.println("DVD," + p.getTitle() + "," + p.getCreator() +"," +
                                       p.getPrice() + "," + p.getAmnt() + "," + ((DVD)p).getGenre()
                               + "," + ((DVD)p).getScore());
                           }
                           else {
                               outFS.println("CD," + p.getTitle() + "," + p.getCreator() +"," +
                                       p.getPrice() + "," + p.getAmnt() + "," + ((CD)p).getPlatinum()
                               + "," + ((CD)p).getHours());
                           }
                       }
                       outFS.close();
                   }
                   catch (FileNotFoundException e){
                       System.out.println("Inventory file not found in directory");
                   }
                   try {
                       FileOutputStream fs2 = new FileOutputStream("MemberList.txt");
                       PrintWriter outFS2 = new PrintWriter(fs2);
                       for (Member m: memberlist){
                           outFS2.println(m.getUser() + "," + m.getPass() + "," + 
                                   m.isPremium() + "," + m.getTotal());
                       }
                       outFS2.close();
                   }
                   catch (FileNotFoundException e){
                       System.out.println("Memberlist file not found in directory");
                   }
                   try {
                       FileOutputStream fs3 = new FileOutputStream("DailyReport.txt");
                       PrintWriter outFS3 = new PrintWriter(fs3);
                       outFS3.println("Total daily sales: " + report.getTotal());
                       outFS3.println("Total new members: " + newMembers);
                       outFS3.println("All purchases by customers today: ");
                       for (Product p: report.getCart()){
                           if (p instanceof Book){
                              String s;
                              if (((Book)p).getBestSeller()){
                                  s = "Best Seller";
                              }
                              else {
                                  s = "Not Best Seller";
                              }
                              outFS3.println("Book, " + p.getTitle() + ", $" + p.getPrice() + ", " + p.getAmnt() + ", " + s
                                      + ", " + ((Book)p).getPages() + " pages long");
                           }
                           else if (p instanceof CD){
                              String s;
                              if (((CD)p).getPlatinum()){
                                  s = "Platinum";
                              }
                              else {
                                  s = "Not Platinum";
                              }
                              outFS3.println("CD, " + p.getTitle() + ", $" + p.getPrice() + ", " + p.getAmnt() + ", " + s
                                      + ", " + ((CD)p).getHours() + " hours long");
                           }
                           else {
                              outFS3.println("DVD, " + p.getTitle() + ", $" + p.getPrice() + ", " + p.getAmnt() + ", " + ((DVD)p).getGenre()
                                      + ", " + ((DVD)p).getScore() + " on Rotten Tomatoes");
                           }
                           
                           outFS3.close();
                       }
                   }
                   catch (FileNotFoundException e){
                       
                   }
                   break loop;
               // case for shopping
                case 1:
                // loop for shopping function
                shopping: while(true){
                    if (account.getUser() == null){
                        System.out.println("You must be signed in to go shopping");
                        break shopping;
                   
               }                    
                    System.out.println("What would you like to buy?");
                    ArrayList<Integer> ID_list = new ArrayList();
                    System.out.println("\t0. To stop shopping");
                    for (Product i : stock.getProductList()){
                    ID_list.add(i.getProductId());
                    i.asString();
                    }
                    try{
                    int option = sc.nextInt();
                    if (option == 0){
                    break shopping;
                    }
                    
                    
                    else if (ID_list.contains(option)){
                        int amount = 0;
                        check: while(true){
                            System.out.println("How many would you like to buy?");
                            try{
                                amount = sc.nextInt();
                                if (amount > stock.getProductList().get(option - 1).getAmnt()){
                                    System.out.println("You cannot buy more than what we have in stock");
                             }
                                else if (amount < 0){
                                    System.out.println("You cannot buy a negative amount of copies");
                                }
                                else {
                                    break check;
                                } 
                            }
                            catch (InputMismatchException e){
                                System.out.println("Input must be an integer");
                            }
                            catch (Exception e){
                                System.out.println("Something weird happened");
                            }
                        }
                        myCart.AddToCart(stock.getProductList().get(option - 1), amount);
                        report.AddToCart(stock.getProductList().get(option - 1), amount);
                        stock.RemoveFromInventory(stock.getProductList().get(option - 1), amount);
                        System.out.println("Your cart now contains");
                        for (Product i: myCart.getCart()){
                            i.asString();
                    }
                    
                }
                    else {
                     System.out.println("You must pick a valid option");       
                    }
                }
                    catch (InputMismatchException e){
                        System.out.println("Input must be an integer");
                    }
                    catch (Exception e){
                        System.out.println("Something weird happened");
                    }
                }
               break;
               //case for checking out 
               case 2:
                   checkout: while (true){
                   if (myCart.getCart().isEmpty()){
                       System.out.println("Your cart is empty");
                       break checkout;
                   }
                   else{
                       System.out.println("Your cart contains");
                        for (Product i: myCart.getCart()){
                            i.asString();
                        }
                        System.out.println("Your total is " + myCart.getTotal());
                        System.out.println("Are you sure you are ready to check out?");
                        System.out.println("\t 1. Yes");
                        System.out.println("\t 2. No");
                        try{
                            int yes = sc.nextInt();
                            switch(yes){
                                case 1:
                                    System.out.println("Thank you for shopping wiht us");
                                    account.addTotal(myCart.getTotal());
                                    myCart.ClearCart();
                                    break checkout;
                                case 2:
                                    break checkout;
                                default:
                                    System.out.println("Please enter 1 or 2");
                            }
                        }
                        catch (InputMismatchException e){
                            System.out.println("Input must be an integer");
                        }
                        catch (Exception e){
                            System.out.println("Something weird happened");
                        }
                        
                   }
                   }   
                   break;
               //case for signing into an existing account 
               case 3:
                   sign: while (true){
                        System.out.println("Enter username: (type exit to leave sign in)");
                        try {
                            String user = sc.next();
                            if (user.equals("exit")){
                                break sign;
                            }
                            int index = -1;
                            for (int i = 0; i<memberlist.size(); i++){
                                if (memberlist.get(i).getUser().equals(user)){
                                    index = i;
                            } 
                            }
                            if (index == -1){
                                System.out.println("User not in found");
                            }
                            else {
                                System.out.println("Enter password:");
                                String pass = sc.next();
                                if (memberlist.get(index).getPass().equals(pass)){
                                    account = memberlist.get(index);
                                    System.out.println("You are signed in");
                                    break sign;
                                }
                                else{
                                    System.out.println("You're password is incorrect");
                                }
                            }
                        }
                        catch (Exception e){
                            System.out.println("Something messed up with the scanner. Try something else.");
                        }
                   }
                   break;
               // case for creating a new account 
               case 4:
                   create: while (true){
                        System.out.println("Enter username");
                       try {
                            String user  = sc.next();
                            account.setUser(user);
                            System.out.println("Enter password");
                            String pass = sc.next();
                            account.setPass(pass);
                            System.out.println("Do you want to join our premium membership? (Type yes for yes)");
                            String prem = sc.next();
                            if (prem.equals("yes")){
                                account.setPremium(true);
                            }
                            else {
                                account.setPremium(false);
                            }
                            System.out.println("Here is your account info");
                            System.out.println("\t Username: " + account.getUser());
                            System.out.println("\t Password: " + account.getPass());
                 
                            String mem = "";
                            if (account.isPremium()){
                            mem = "Premium";
                            }
                            else {
                                mem = "Normal";
                            }
                            System.out.println("\t Membership type: " + mem);
                            satisfied: while (true){
                                System.out.println("Are you happy with your account?");
                                System.out.println("\t 1. Yes");
                                System.out.println("\t 2. No");
                                try {
                                int yes = sc.nextInt();
                                switch (yes){
                                    case 1:
                                        System.out.println("You're account has been created and you are now signed in");
                                        newMembers += 1;
                                        break create;
                                    case 2:
                                        break satisfied;
                                    default:
                                        System.out.println("You must enter 1 or 2");
                                }
                                }
                                catch (InputMismatchException e){
                                        System.out.println("Input must be an Integer");
                                    }
                        }
                        
                    }
                   catch (Exception e){
                       System.out.println("Something went wrong with scanner. Try again!");
                   }
                   }
                   memberlist.add(account);
                   break;
               // case for checking account running total
               case 5:
                   if (account.getUser() == null){
                        System.out.println("You must be signed in to view running total");
                        break;
                   }
                   System.out.println("Your running total is: " + account.getTotal());
                   
                           
                   break;
               // case for adding to inventory
               // if we were to actually make this we would want to implement a field in member or extend it to an employee class
               case 6:
                   restock: while(true){
                       System.out.println("Our inventory is:");
                         for (Product p: stock.getProductList()){
                            p.asString();
                   }
                        System.out.println("Enter the ID of product you would like to restock or enter -1 to exit:");
                        try {
                            int ID = sc.nextInt();
                            if (ID == -1){
                                break restock;
                            }
                            System.out.println("Enter the amount you would like to add to stock");
                            try {
                                int count = sc.nextInt();
                                System.out.println("You are going to add " + count + " to the product with " +
                                    ID + " as its ID");
                                System.out.println("Are you sure you want to do this");
                                System.out.println("\t 1. Yes");
                                System.out.println("\t 2. No");
                                try {
                                    int decision = sc.nextInt();
                                    switch (decision){
                                    case 1:
                                        stock.restockProduct( ID, count);
                                        System.out.println("Restock successful");
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("You must enter 1 or 2");
                                        break;
                                    }
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Input must be an integer");
                                    }
                            }
                            catch (InputMismatchException e){
                                System.out.println("Input must be an integer");
                        }
                    }
                        catch (InputMismatchException e){
                            System.out.println("Input must be an integer");
                        }
                   }
                   break;
               case 7:
                   System.out.println("$" + stock.inventoryValue());
                   break;
                   
               case 8:
                   for (Product p : stock.getProductList()){
                       tempList.add(p);
                   }
                   Collections.sort(tempList);
                   for (Product p: tempList){
                       p.asString();
                   }
                   tempList.clear();
                   break;
                //if you don't enter something right this happens
               default:
                   System.out.println("You must enter 0,1,2,3,4,5,6,7, or 8");
                }
           }
           catch (InputMismatchException e){
               System.out.println("Must input an integer");
           }
        }            
    }
    }

