package Project;

import java.util.ArrayList;

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

    private static int count = 0;

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
    
    public void createLaptop(int lCounter, ArrayList<Product> inventoryList){
                    System.out.println("Please enter the brand of the Laptop: ");
                    String brand = kb.next();
                    System.out.println("Please enter the Processor of the Laptop (i3, i5, or i7): ");
                    String proc = kb.next();                 
                    proc = processorValidation(kb,proc);
                    System.out.println("Please enter the Hard Drive Size of the Laptop: ");
                    int hdd = kb.nextInt();
                    System.out.println("Please enter the RAM of the Laptop: (4, 6, 8 Gigabytes)");
                    int ram = kb.nextInt();
                    //RAMValidation
                    ramValidation(kb,ram);
                    System.out.println("Please enter the Cost of the Laptop: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Laptop: ");
                    double price = kb.nextDouble();
                    price = priceValidation(kb,cost,price);
                    System.out.println("Please enter the Screen Size of the Laptop: ");
                    String screen = kb.next();
                    System.out.println("Is the keyboard backlit? (true/false)");
                    boolean backlight = kb.nextBoolean();
                    System.out.println("Is there a fingerprint reader? (true/false) ");
                    boolean fingerPrint = kb.nextBoolean();
                    Laptops newPC = new Laptops(brand, proc, hdd, ram, cost, price, screen, backlight, fingerPrint);
//                    lap[lCounter] = new Laptops(brand, proc, hdd, ram, cost, price, screen, backlight, fingerPrint);
                    inventoryList.add(newPC);
                    lCounter++;

    }

}
