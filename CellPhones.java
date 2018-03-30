package poject331;

/*
 author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;

public class CellPhones {
	
    private String brand;
    private String screenSize;
    private int memory;
    private double cost;
    private double sellPrice;
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int aCount) {
        count = aCount;
    }
    
    /**
     * Default constructor.
     */
    public CellPhones() {
        count++;
    }

    public CellPhones(String brand, String screenSize, int memory, double cost, double sellPrice) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.memory = memory;
        this.cost = cost;
        this.sellPrice = sellPrice;
        
        count++;
    }

    public String getBrand() {
        return brand;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public int getMemory() {
        return memory;
    }

    public double getCost() {
        return cost;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setBrand(String Brand) {
        this.brand = brand;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "CellPhones{" + "Brand=" + brand + ", screenSize=" + screenSize + ", memory=" + memory + ", cost=" + cost + ", sellPrice=" + sellPrice + '}';
    }
    
    
    
    
}
