/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System Prototype.
 */

package Project;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryApp {
    
    /**
     * Adds items to inventory and manages inventory.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        ArrayList<Product> inventoryList = new ArrayList<Product>();
        Product p = new Product();
        Desktop d = new Desktop();
        CellPhones c = new CellPhones();
        Laptops l = new Laptops();
        int input = 0;
        int cpCounter = 0;//Keep tally of how many in stock
        int lCounter = 0;
        int dCounter = 0;
        
        while(input !=8){//loop through menu
          System.out.printf("%-25s%-25s\n","1.Add Desktop","5.Print Laptop(s)");
          System.out.printf("%-25s%-25s\n","2.Add Laptop", "6 Print Cellphone(s)");
          System.out.printf("%-25s%-25s\n", "3 Add Cellphone","7.Print All Items");
          System.out.printf("%-25s%-25s\n", "4 Print Desktop(s)","8.Exit System");
            input = kb.nextInt(); 
            switch(input){
                case 1://Write into desktop 
                {
                    dCounter++;
                    d.createDesktop(dCounter, inventoryList);
                    break;
                }
                case 2://write into Laptop
                {
                      lCounter++;
                      l.createLaptop(lCounter, inventoryList);      
                    break;
                }
                case 3://write into CellPhones
                {
                      cpCounter++;
                      c.createCellPhone(cpCounter, inventoryList);
                    break;
                }
                case 4:
                {
                    printDesktop(dCounter, inventoryList);
                    break;
                }
                case 5:
                {
                   printLaptop(lCounter, inventoryList);
                    break;
                }
                case 6:
                {
                    printCellPhone(cpCounter, inventoryList);
                    break;
                }
                case 7://Print all
                {
                    printDesktop(dCounter, inventoryList);
                   printLaptop(lCounter, inventoryList);
                    printCellPhone(cpCounter, inventoryList);
                    break;
                    
                }
                            
            }
        
        }
    }
    
/**
 * Prints desktop price, brand, and cost
 * @param dCounter the amount of desktops in inventory
 * @param desk the array of desktops that hold inventory
 */    
    public static void printDesktop(int dCounter, ArrayList<Product> desk)
    {
                      
                    System.out.print(dCounter + " Desktop Computer(s): \n");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n" ,"IDNum","Brand","Cost","Selling Price",
                            "Processor","Ram","Drive Size");
                    for(Product p: desk){
                        if(p instanceof Desktop && !(p instanceof Laptops))
                            System.out.println(desk.indexOf(p) + "\t\t" + ((Desktop) p).toString());
                    }
    }
    
    /**
     * Prints laptop price, brand, and cost.
     * @param lCounter the amount of laptops in inventory
     * @param lap the array of laptops that hold inventory
     */
    public static void printLaptop(int lCounter, ArrayList<Product> lap)
    {
                    System.out.println(lCounter + " Laptop Computer(s): \n");
                     System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s\n" ,"IDNum","Brand","Cost","Selling Price",
                            "Processor","Ram","Drive Size","Screen Size","Backlit","Finger Printer");
                    for (Product p: lap){
                        if (p instanceof Laptops){
                            System.out.println(((Laptops) p).toString()); 
                        }
                    }
    }
    
    /**
     * Prints cellphone brand, cost, sale price.
     * @param cpCounter the amount of cellphones in inventory
     * @param cp the inventory that holds the cellphones
     */
    public static void printCellPhone(int cpCounter, ArrayList<Product> cp)
    {
                    System.out.println(cpCounter + " Cell Phone(s): ");
                    System.out.printf("%-15s%-15s%-15s\n","Brand","Cost","Selling Price");
                    
                    for (Product p: cp){
                        if (p instanceof CellPhones){
                            
                        System.out.println(p.toString());
                        
                    }
                    }
    }
}

    


