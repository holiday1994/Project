package poject331;

/*
author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;

public class desktop {
    
    private String brand;
    private String processor;
    private int hardDriveSize;
    private int ram;
    private double purchaseCost;
    private double salesPrice;
    
    private static int count =  0;
    
    public desktop(){
        this.brand = "";
        this.processor = "";
        this.hardDriveSize = 0;
        this.ram = 0;
        this.purchaseCost = 0.0;
        this.salesPrice = 0.0;
        
        count++;
    }

    public desktop(String bran, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice) {
        brand = bran;
        this.processor = processor;
        this.hardDriveSize = hardDriveSize;
        this.ram = ram;
        this.purchaseCost = purchaseCost;
        this.salesPrice = salesPrice;
        
        count++;
    }
    
    

    public String getBrand() {
        return brand;
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

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public static int getCount() {
        return count;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public static void setCount(int count) {
        desktop.count = count;
    }
    
    
}
