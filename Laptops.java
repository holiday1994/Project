package Project;

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
public class Laptops extends Desktop {
     private String screensize;
     private boolean backlit;
     private boolean fingerprintReader;
    
    private static int count =  0;

    public Laptops() {
        super();
        this.screensize = "";
        this.backlit = false;
        this.fingerprintReader = false;
        count++;
    }

    public Laptops(String brand, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice, String screensize, boolean backlit, boolean fingerprintReader) {

        super(brand, processor, hardDriveSize, ram, purchaseCost, salesPrice);
        this.screensize = screensize;
        this.backlit = backlit;
        this.fingerprintReader = fingerprintReader;
        
        count++;
    }

    public String getScreensize() {
        return screensize;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public boolean isFingerprintReader() {
        return fingerprintReader;
    }

    public static int getCount() {
        return count;
    }

    public void setScreensize(String screensize) {
        this.screensize = screensize;
    }

    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }

    public void setFingerprintReader(boolean fingerprintReader) {
        this.fingerprintReader = fingerprintReader;
    }

    public static void setCount(int count) {
        Laptops.count = count;
    }
    
    
    
    
}
