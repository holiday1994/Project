/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 4/3/2018
purpose: Better Buy Prototype Inventory Mangement System Prototype.

This file allows users to interact and manage cellphones. Add, update, delete cellphones
 */
package Project;

import java.util.ArrayList;
import java.util.Scanner;
public class CellPhones extends Product {

    private int screenSize;
    private int memory;
    private static int count = 0;
    private static String typeCP = "Cell Phone";
    


    /**
     * Default constructor.
     */
    public CellPhones() {
        super();
        this.memory = 0;
        this.screenSize = 0;
      
    }

    public CellPhones(String brand, int screenSize, int memory, double cost, double sellPrice) {
        super(brand, cost, sellPrice);
        this.screenSize = screenSize;
        this.memory = memory;

//        count++;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getMemory() {
        return memory;
    }
    public String getType(){
        return this.typeCP;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
    
    public int getCount() {
        return count;
    }
   
    public void setCount(int aCount) {
        count = aCount;
    }

    
    @Override
    public String toString() {
        String master = "";
        master = String.format("%-15d%-15s$%-14.2f$%-19.2f%-15s%-15d" ,this.getUniqueID(), this.getBrand(), this.getCost(),this.getSellPrice(),this.getScreenSize(),this.getMemory());        
        return master;
    }
    
    
    public int cellMemoryValidation(Scanner kb, int memory) {

        while (memory != 32 || memory != 64 || memory != 256) {
            if (memory == 32 || memory == 64 || memory == 256) {
                break;
            } else {
                System.out.println("Please pick between 32, 64, or 256 Gigabytes: ");
                memory = kb.nextInt();
            }
        }
        return memory;
    }
    
    public int screenSizeValidation(Scanner kb, int screen){
    {
        while (screen != 4 && screen != 5 && screen != 6 && screen != 7 && screen !=8)
             {
                 if (screen == 4 || screen == 5 || screen == 6 || screen == 7 || screen ==8)
                     break;
                 else{
                        System.out.println("Please choose between 4, 5, 6, 7, or 8 for Screen Size: ");
                        screen = kb.nextInt();
                 }
             }
        return screen;
         }
    }
    
    public void createCellPhone(ArrayList<Product> inventoryList){
                    System.out.println("Please enter the brand of the Cell Phone: ");
                    String brand = kb.next();
                    System.out.println("Please enter the Screen Size of the Cell Phone, choose from 4, 5, 6, 7, 8, (inches):");
                    int screen = kb.nextInt();  
                    screenSizeValidation(kb,screen);
                    System.out.println("Please enter the Memory of the Cell Phone, choose from 32, 64, or 256 (Gigabytges): ");
                    int memory = kb.nextInt();
                    memory = cellMemoryValidation(kb,memory);
                    System.out.println("Please enter the Cost of the Cell Phone: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Cell Phone: ");
                    double price = kb.nextDouble();
                    price = priceValidation(kb,cost,price);
                    CellPhones newPhone = new CellPhones(brand, screen, memory, cost, price);
                    inventoryList.add(newPhone);
                    newPhone.setUniqueID(inventoryList.indexOf(newPhone));
                    count++;
                    
    }
}