package Project;

import Project.Product;

/*
 author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;

public class CellPhones extends Product{
	
    private String screenSize;
    private int memory;
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
        super();
        this.memory = 0;
        this.screenSize = "";
        count++;
    }

    public CellPhones(String brand, String screenSize, int memory, double cost, double sellPrice) {
        super(brand, cost, sellPrice);
        this.screenSize = screenSize;
        this.memory = memory;

        
        count++;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public int getMemory() {
        return memory;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "CellPhones{" + "Brand=" + ", screenSize=" + screenSize + ", memory=" + memory + ", cost=" + ", sellPrice=" + '}';
    }
    
    
    
    
}
