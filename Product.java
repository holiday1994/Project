/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System Prototype.
 */
package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    private String brand;
    private double cost;
    private double sellPrice;
    private int uniqueId = 0;
    
    Scanner kb = new Scanner(System.in);
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
        this.uniqueId++;
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

}
