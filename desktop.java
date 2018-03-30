package poject331;

import Project.Product;

/*
author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;

public class desktop extends Product {
    
    private String processor;
    private int hardDriveSize;
    private int ram;
    
    private static int count =  0;
    
    public desktop(){
        super();
        this.processor = "";
        this.hardDriveSize = 0;
        this.ram = 0;
        count++;
    }

    public desktop(String brand, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice) {
        super(brand, purchaseCost, salesPrice);
        this.processor = processor;
        this.hardDriveSize = hardDriveSize;
        this.ram = ram;     
        count++;
    }
    

    public String getProcessor() {
        return processor;
    }

    public int getHardDriveSize() {
        return hardDriveSize;
    }

    public int getRam() {
        return ram;
    }

    public static int getCount() {
        return count;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setHardDriveSize(int hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public static void setCount(int count) {
        desktop.count = count;
    }
    
    
}
