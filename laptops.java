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
public class laptops extends desktop {
     private String screensize;
     private String backlit;
     private String fingerprintReader;
    
    private static int count =  0;

    public laptops() {
        super();
        this.screensize = "";
        this.backlit = "";
        this.fingerprintReader = "";
        count++;
    }

    public laptops(String brand, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice, String screensize, String backlit, String fingerprintReader) {

        super(brand, processor, hardDriveSize, ram, purchaseCost, salesPrice);
        this.screensize = screensize;
        this.backlit = backlit;
        this.fingerprintReader = fingerprintReader;
        
        count++;
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
