/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author holly
 */
public class Product {
    private String brand;
    private double cost;
    private double sellPrice;

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
    
}
