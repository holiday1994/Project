/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 2/27/18 
purpose: Better Buy Prototype Inventory Mangement System Prototype. 
 */
package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Desktop extends Product {

    private String processor;
    private int hardDriveSize;
    private int ram;
    private static int count = 0;


    public Desktop() {
        super();
        this.processor = "";
        this.hardDriveSize = 0;
        this.ram = 0;
        
        
        
    }

    public Desktop(String brand, String processor, int hardDriveSize, int ram, double purchaseCost, double salesPrice) {
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

    public int getCount() {
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

    public void setCount(int count) {
        Desktop.count = count;
    }

    @Override
    public String toString() {
        String master = ""; 
        master = String.format("%-15d%-15s%-15.2f%-20.2f%-15s%-15d%-15d",this.getUniqueID(),this.getBrand(), this.getCost(),this.getSellPrice(),
                this.getProcessor(), this.getRam(), this.getHardDriveSize());

        return master;

    }
    

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
    
        public String processorValidation(Scanner kb, String proc){
             while (proc.equalsIgnoreCase("i3")==false)
             {
                 if (proc.equalsIgnoreCase("i5")==true || proc.equalsIgnoreCase("i7")==true)
                     break;                                
                                              
                 else
                 {
                        System.out.println("Please choose between a i3, i5, or i7 Processor: ");
                        proc = kb.next();}  
                  
             }
             return proc;
        }

        
        public void createDesktop(ArrayList<Product> inventoryList){
                    
                    System.out.println("Please enter the brand of the Desktop: ");
                    String brand = kb.next();                    
                    
                    //Data validation for processors
                    System.out.println("Please enter the Processor of the Desktop(i3, i5, or i7): ");
                    String proc = kb.next(); 
                    //calls processorValidation Method
                    proc = processorValidation(kb,proc);

                    System.out.println("Please enter the Hard Drive Size of the Desktop: ");
                    int hdd = kb.nextInt();
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
                    
                  
        }

}
