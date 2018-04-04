/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 4/3/2018
purpose: Better Buy Prototype Inventory Mangement System Prototype. 
This class handles all desktop objects and is a child of the product class.
 */
package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Desktop extends Product {

    private String processor;
    private int hardDriveSize;
    private int ram;
    private static int count = 0;
    private static String typeD = "Desktop"; 

    //0 arg constructor
    public Desktop() {
        super();
        this.processor = "";
        this.hardDriveSize = 0;
        this.ram = 0;
         
    }
    
    //Constructor
    public Desktop(String brand, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice) {
        super(brand, purchaseCost, salesPrice); //Calls the super classes constructor
        this.processor = processor;
        this.hardDriveSize = hardDriveSize;
        this.ram = ram;
//        count++;
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

    public int getCount() {
        return count;
    }
    
    public String getType(){
        return this.typeD;
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

    public void setCount(int count) {
        Desktop.count = count;
    }
    

    //Holds the display message for desktop objects
    @Override
    public String toString() {
        String master = ""; 
        master = String.format("%-15d%-15s$%-14.2f$%-19.2f%-15s%-15d%-15d",this.getUniqueID(),this.getBrand(), this.getCost(),this.getSellPrice(),
                this.getProcessor(), this.getRam(), this.getHardDriveSize());

        return master;

    }
    
    //Validates Ram
    public int ramValidation(Scanner kb, int ram) {
        while (ram != 4 || ram != 6 || ram != 8 || ram!=16) {
            if (ram == 4 || ram == 6 || ram == 8 || ram == 16) {
                break;
            } else {
                System.out.println("Please pick between 4, 6, 8, or 16 Gigabytes: ");
                ram = kb.nextInt();
            }
        }
        return ram;
    }
        //Validates Processors
        public String processorValidation(Scanner kb, String proc){
             while (proc.equalsIgnoreCase("i3")==false || proc.equalsIgnoreCase("i5") == false || proc.equalsIgnoreCase("i7") == false)
             {
                 if (proc.equalsIgnoreCase("i3")==true || proc.equalsIgnoreCase("i5")==true || proc.equalsIgnoreCase("i7")==true)
                     break;                                                                              
                 else
                 {
                        System.out.println("Please choose between a i3, i5, or i7 Processor: ");
                        proc = kb.next();}                   
             }
             return proc;
        }
        
        //Validates harddrives
        public int hardDriveValidation(Scanner kb, int hdd){
             while (hdd != 128)
             {
                 if (hdd == 256 || hdd == 500 || hdd == 1000)
                     break;                                                                              
                 else
                 {
                        System.out.println("Please choose between a 128, 256, 500, or 1000 Hard-Drive Size: ");
                        hdd = kb.nextInt();}                   
             }
             return hdd;
        }

        //Holds the output requesting userinput and creates desktop objects based
        //user input
        public void createDesktop(ArrayList<Product> inventoryList){
                    
                    System.out.println("Please enter the brand of the Desktop: ");
                    String brand = kb.next();                    
                    
                    //Data validation for processors
                    System.out.println("Please enter the Processor of the Desktop(i3, i5, or i7): ");
                    String proc = kb.next(); 
                    //calls processorValidation Method
                    proc = processorValidation(kb,proc);

                    System.out.println("Please enter the Hard Drive Size of the Desktop(128, 256, 500, 1000): ");
                    int hdd = kb.nextInt();
                    //calls hardDriveValidation Method
                    hdd = hardDriveValidation(kb, hdd);
                    System.out.println("Please enter the RAM of the Desktop:(4, 6, 8, 16 Gigabytes) ");
                    
                    //Data Validation for  RAM, make sure it is either 4, 6, 8, 16 orGigabytes
                    int ram = kb.nextInt();
                    ram = ramValidation(kb,ram);
                     
                    System.out.println("Please enter the Cost of the Desktop: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Desktop: ");
                    double price = kb.nextDouble();
                    price = priceValidation(kb,cost,price);
                    Desktop a = new Desktop(brand, proc, hdd, ram, cost, price);
                    inventoryList.add(a);
                    a.setUniqueID(inventoryList.indexOf(a));
                    count++;
                    
        }

}
