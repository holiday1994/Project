/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author holly
 */
public class Product {

    private String brand;
    private double cost;
    private double sellPrice;
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
