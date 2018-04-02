/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System Prototype.
 */
package Project;

import java.util.ArrayList;
import java.util.Scanner;
public class CellPhones extends Product {

    private String screenSize;
    private int memory;
    private static int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int aCount) {
        count = aCount;
    }

    /**
     * Default constructor.
     */
    public CellPhones() {
        super();
        this.memory = 0;
        this.screenSize = "";
      
    }

    public CellPhones(String brand, String screenSize, int memory, double cost, double sellPrice) {
        super(brand, cost, sellPrice);
        this.screenSize = screenSize;
        this.memory = memory;

        count++;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public int getMemory() {
        return memory;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        String master = "";
        master = String.format("%-15d%-15s%-15.2f%-15.2f%-15s%-15d" ,this.getUniqueID(), this.getBrand(), this.getCost(),this.getSellPrice(),this.getScreenSize(),this.getMemory());        
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
    
    public void createCellPhone(ArrayList<Product> inventoryList){
                    System.out.println("Please enter the brand of the Cell Phone: ");
                    String brand = kb.next();
                    System.out.println("Please enter the Screen Size of the Cell Phone: ");
                    String screen = kb.next();                  
                    System.out.println("Please enter the Memory of the Cell Phone, choose from 32, 64, or 256 Gigabytges: ");
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
                    
    }
}
