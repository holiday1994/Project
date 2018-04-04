/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
date: 4/3/2018
purpose: Better Buy Prototype Inventory Mangement System Prototype.
//Disclaimer: Everyone in this group has distributed work evenly throught the Programming assignment

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
        //int cpCounter = 0;//Keep tally of how many in stock
        //int lCounter = 0;
        //int dCounter = 0;
        
        while(input !=9){//loop through menu
          System.out.printf("%-25s%-25s\n","1.Add Desktop","5.Print Laptop(s)");
          System.out.printf("%-25s%-25s\n","2.Add Laptop", "6 Print Cellphone(s)");
          System.out.printf("%-25s%-25s\n", "3 Add Cellphone","7.Print All Items");
          System.out.printf("%-25s%-25s\n", "4 Print Desktop(s)","8.Profitability Report");
          System.out.println("9.Exit System");
            input = kb.nextInt(); 
            switch(input){
                case 1://Write into desktop 
                {
                    //dCounter++;
                    d.createDesktop(inventoryList);
                    break;
                }
                case 2://write into Laptop
                {
                      //lCounter++;
                      l.createLaptop(inventoryList);      
                    break;
                }
                case 3://write into CellPhones
                {
                      //cpCounter++;
                      c.createCellPhone(inventoryList);
                    break;
                }
                case 4:
                {
                    printDesktop(d, inventoryList);
                    break;
                }
                case 5:
                {
                   printLaptop(l, inventoryList);
                    break;
                }
                case 6:
                {
                    printCellPhone(c, inventoryList);
                    break;
                }
                case 7://Print all
                {
                    printDesktop(d, inventoryList);
                    printLaptop(l, inventoryList);
                    printCellPhone(c, inventoryList);
                    break;
                    
                }
                case 8:
                    printCompleteReport(d,l,c,inventoryList);
                            
            }
        
        }
    }
    
/**
 * Prints desktop price, brand, and cost
 * @param dCounter the amount of desktops in inventory
 * @param desk the array of desktops that hold inventory
 */    
    public static void printDesktop(Desktop d, ArrayList<Product> desk)
    {
                      
                    System.out.print("\n" + d.getCount() + " Desktop Computer(s): \n");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n" ,"IDNum","Brand","Cost","Selling Price",
                            "Processor","Ram","Drive Size");
                    for(Product p: desk){
                        if(p instanceof Desktop && !(p instanceof Laptops))
                            System.out.println(p.toString());
                    }
    }
    /**
     * Prints laptop price, brand, and cost.
     * @param lCounter the amount of laptops in inventory
     * @param lap the array of laptops that hold inventory
     */
    public static void printLaptop(Laptops lp, ArrayList<Product> lap)
    {
                    System.out.print("\n" + lp.getCount() + " Laptop Computer(s): \n");
                     System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s\n" ,"IDNum","Brand","Cost","Selling Price",
                            "Processor","Ram","Drive Size","Screen Size","Backlit","Finger Print Reader");
                    for (Product p: lap){
                        if (p instanceof Laptops){
                            System.out.println(p.toString()); 
                        }
                    }
    }
    
    /**
     * Prints cellphone brand, cost, sale price.
     * @param cpCounter the amount of cellphones in inventory
     * @param cp the inventory that holds the cellphones
     */
    public static void printCellPhone(CellPhones cell, ArrayList<Product> cp)
    {
                    System.out.println("\n" + cell.getCount() + " Cell Phone(s): ");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s\n","IDNUM","Brand","Cost","Selling Price","Screen Size"
                            ,"Memory");
                    
                    for (Product p: cp){
                        if (p instanceof CellPhones){
                            
                        System.out.println(p.toString());
                        
                    }
                    }
                    
    }
    
    
        public static void printCompleteReport(Desktop d, Laptops l, CellPhones cp ,ArrayList <Product> inventoryList){
        System.out.println("=====================================");
        System.out.println("Complete Report: ");
        System.out.printf("%-20s%-20s%-20s%-21s%-20s\n" ,"Unique ID","Selling Price","Cost","Capital Gains","Product Type");
        
        for (Product p: inventoryList){
            System.out.printf("%-20d$%-19.2f$%-19.2f$%-20.2f", p.getUniqueID(), p.getSellPrice(), 
                    p.getCost(), p.getSellPrice() - p.getCost());
            if (p instanceof Desktop){
                System.out.printf("%-20s\n",((Desktop) p).getType());
                }
            else if (p instanceof Laptops){
                System.out.printf("%-20s\n",((Laptops) p).getType());
            }
            else if (p instanceof CellPhones){
                System.out.printf("%-20s\n",((CellPhones) p).getType());
            }
        }
        System.out.println(profitReport(d,l,cp,inventoryList));
    }
    
    /**
     * Prints the profit report of the store.
     * 
     * @param d desktop used to get the amount of desktops
     * @param l laptops used to get the amount of laptops
     * @param cp cellphones used to geth the amount of cellphones
     * @param inventoryList the store's current inventory
     * @return result
     */
    public static String profitReport (Desktop d, Laptops l, CellPhones cp, ArrayList <Product> inventoryList){
        double revenue = 0;
        double cost = 0;
        double profit;
        for (Product p: inventoryList){
            
            revenue += p.getSellPrice();
            cost += p.getCost();
        }
        profit = revenue - cost;
        String result = String.format ("\nTotal Revenue: $%-14.2f\nTotal Cost: $%-15.2f\nTotal Profit: $%-15.2f\n",
                revenue, cost, profit);
                result += ("Desktops: " + d.getCount() + "   Laptops: " + l.getCount() + "   Cell Phones: " + cp.getCount());
        return result;   
    }
    
    
    
    
}
    


