package Project;

import java.util.ArrayList;
import java.util.Scanner;

/*
 author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;
public class CellPhones extends Product {

    private String screenSize;
    private int memory;
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int aCount) {
        count = aCount;
    }

    /**
     * Default constructor.
     */
    public CellPhones() {
        super();
        this.memory = 0;
        this.screenSize = "";
        count++;
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
        return "CellPhones{" + "Brand=" + ", screenSize=" + screenSize + ", memory=" + memory + ", cost=" + ", sellPrice=" + '}';
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
    
    public void createCellPhone(int cpCounter, ArrayList<Product> inventoryList){
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
//                    cp[cpCounter] = new CellPhones(brand, screen, memory, cost, price);
                    inventoryList.add(newPhone);
                    cpCounter++;
    }
}
