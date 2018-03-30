package poject331;

/*
author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;

/**
 *
 * @author holly
 */
public class laptops {
     private String brand;
     private String processor;
     private int hardDriveSize;
     private int ram;
     private double purchaseCost;
     private double salesPrice;
     private String screensize;
     private String backlit;
     private String fingerprintReader;
    
    private static int count =  0;

    public laptops() {
        count++;
    }

    public laptops(String brand, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice, String screensize, String backlit, String fingerprintReader) {
        this.brand = brand;
        this.processor = processor;
        this.hardDriveSize = hardDriveSize;
        this.ram = ram;
        this.purchaseCost = purchaseCost;
        this.salesPrice = salesPrice;
        this.screensize = screensize;
        this.backlit = backlit;
        this.fingerprintReader = fingerprintReader;
        
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

    public String getScreensize() {
        return screensize;
    }

    public String isBacklit() {
        return backlit;
    }

    public String isFingerprintReader() {
        return fingerprintReader;
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

    public void setScreensize(String screensize) {
        this.screensize = screensize;
    }

    public void setBacklit(String backlit) {
        this.backlit = backlit;
    }

    public void setFingerprintReader(String fingerprintReader) {
        this.fingerprintReader = fingerprintReader;
    }

    public static void setCount(int count) {
        laptops.count = count;
    }
    
    
    
    
}
