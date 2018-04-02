/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 4/3
purpose: Better Buy Prototype Inventory Mangement System Prototype.
 */
package Project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Product {
    Random rand = new Random();
    Scanner kb = new Scanner(System.in);
   
    private String brand;
    private double cost;
    private double sellPrice;
    private int uniqueId; 
    static int count = 0;
    
  
    ArrayList<Product> inventoryList;

    public Product() {
        this.brand = "";
        this.cost = 0.0;
        this.sellPrice = 0.0;
        
    }

    public Product(String brand, double cost, double sellPrice) {
        this.brand = brand;
        this.cost = cost;
        this.sellPrice = sellPrice;
        
    }

    public String getBrand() {
        return brand;
    }

    public double getCost() {
        return cost;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    public int getUniqueID(){
        return this.uniqueId;
    }
    
    public void setUniqueID(int index){
        this.uniqueId = index;
        
    }

    public static double priceValidation(Scanner kb, double cost, double price) {
        while (cost > price) {
            if (price > cost) {
                break;
            }
            System.out.println("Enter a selling price that is greater than the cost... Enter a price greater than: $" + cost);
            System.out.print("Enter a price: ");
            price = kb.nextDouble();
        }

        return price;
    }
    
    public void printCompleteReport(ArrayList <Product> inventoryList){
        System.out.println("Complete Report: ");
        System.out.printf("%-20s%-20s%-20s%-20s\n" ,"Unique ID","Selling Price","Cost","Gains");
        for (Product p: inventoryList){
            System.out.printf("%-20d$%-19.2f$%-19.2f$%-20.2f\n", p.getUniqueID(),p.getSellPrice(), 
                    p.getCost(), p.getSellPrice() - p.getCost());
        }
        System.out.println(profitReport(inventoryList));
    }
    
    public String profitReport (ArrayList <Product> inventoryList){
        double revenue = 0;
        double cost = 0;
        double profit;
        for (Product p: inventoryList){
            
            revenue += p.getSellPrice();
            cost += p.getCost();
        }
        profit = revenue - cost;
        String result = String.format ("Total Revenue: %-15.2fTotal Cost: $%-15.2f\nTotal Profit: $%-15.2f\n",
                revenue, cost, profit);
                result += ("Desktops: " + Desktop.getCount() + "   Laptops: " + Laptops.getCount() + "   Cell Phones: " + CellPhones.getCount());
        return result;   
    }
   
}
