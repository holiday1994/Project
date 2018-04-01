/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System Prototype.
 */
package Project;

import java.util.ArrayList;
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

    public String isBacklit() {
        if (this.backlit == true){
            return "Yes";
        }
        else 
            return "No";
    }

    public String isFingerprintReader() {
        if (this.fingerprintReader== true){
            return "Yes";
        }
        else
            return "No";
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
    
    @Override
    public String toString(){
        
        String master = "";
        master = String.format("%-15s%-15.2f%-20.2f%-15s%-15d%-15d%-15s%-15s%-15s" ,this.getBrand(), this.getCost(),this.getSellPrice(),
                this.getProcessor(), this.getRam(), this.getHardDriveSize(),this.getScreensize(),this.isBacklit()
                ,this.isFingerprintReader());
        return master;
    }
    
    
    public void createLaptop(int lCounter, ArrayList<Product> inventoryList){
                       
                    System.out.println("Please enter the brand of the Laptop: ");
                    String brand = kb.next();
                    System.out.println("Please enter the Processor of the Laptop (i3, i5, or i7): ");
                    String proc = kb.next();                 
                    proc = processorValidation(kb,proc);
                    System.out.println("Please enter the Hard Drive Size of the Laptop: ");
                    int hdd = kb.nextInt();
                    System.out.println("Please enter the RAM of the Laptop: (4, 6, 8, or 16 Gigabytes)");
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
                    inventoryList.add(newPC);
                    lCounter++;

    }

}
