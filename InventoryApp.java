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
//        Desktop[] desk = new Desktop[1000];
//        CellPhones[] cp = new CellPhones[1000];
//        Laptops[] lap = new Laptops[1000];
//        Object[] inv = new Object[1000];
        
        ArrayList<Product> inventoryList = new ArrayList<Product>();

        int input = 0;
        int cpCounter = 0;//Keep tally of how many in stock
        int lCounter = 0;
        int dCounter = 0;
        
        while(input !=8){//loop through menu
            System.out.println("Please choose a selection to input: \n1.Desktop\n2.Laptops\n3.Cell Phones\n");
            System.out.println("Or\n\nChoose to print: \n4.Desktop Inventory\n5.Laptops Inventory \n6.Cell Phones Inventory \n7.Print All\n8.Exit");
            input = kb.nextInt(); 
            switch(input){
                case 1://Write into desktop 
                {
                    System.out.println("Please enter the brand of the Desktop: ");
                    String brand = kb.next();                    
                    
                    //Data validation for processors
                    System.out.println("Please enter the Processor of the Desktop(i3, i5, or i7): ");
                    String proc = kb.next(); 
                    //calls processorValidation Method
                    proc = processorValidation(kb,proc);

                    System.out.println("Please enter the Hard Drive Size of the Desktop: ");
                    int hdd = kb.nextInt();
                    System.out.println("Please enter the RAM of the Desktop:(4, 6, 8 Gigabytes) ");
                    
                    //Data Validation for  RAM, make sure it is either 4 6 or 8 Gigabytes
                    int ram = kb.nextInt();
                    ram = ramValidation(kb,ram);
                     
                    System.out.println("Please enter the Cost of the Desktop: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Desktop: ");
                    double price = kb.nextDouble();
                    price =priceValidation(kb,cost,price);
                    Desktop a = new Desktop(brand, proc, hdd, ram, cost, price);
//                    inv[0] = new Desktop(brand, proc, hdd, ram, cost, price);
//                    desk[dCounter] = new Desktop(brand, proc, hdd, ram, cost, price);
                    inventoryList.add(a);
                    dCounter++;  
                    break;
                }
                case 2://write into Laptop
                {
     
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
                    price =priceValidation(kb,cost,price);
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
                    break;
                }
                case 3://write into CellPhones
                {
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
                    price =priceValidation(kb,cost,price);
                    CellPhones newPhone = new CellPhones(brand, screen, memory, cost, price);
//                    cp[cpCounter] = new CellPhones(brand, screen, memory, cost, price);
                    inventoryList.add(newPhone);
                    cpCounter++;
                    break;
                }
                case 4:
                {
//                    printDesktop(dCounter, desk);
                    printDesktop(dCounter, inventoryList);
                    break;
                }
                case 5:
                {
//                    printLaptop(lCounter, lap);
                    break;
                }
                case 6:
                {
//                    printCellPhone(cpCounter, cp);
                    break;
                }
                case 7://Print all
                {
//                    printDesktop(dCounter, desk);
//                    printLaptop(lCounter, lap);
//                    printCellPhone(cpCounter, cp);
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
                      
                    System.out.println(dCounter + " Desktop Computer(s): ");
                    System.out.println("Brand:\t\tCost:\t\tSale Price:");
//                    for (int i = 0; i < dCounter ; i++)
//                    {
//     
//                    System.out.print(desk[i].getBrand() + "\t\t");
//                    System.out.printf("$%.2f\t\t",desk[i].getCost());
//                    System.out.printf("$%.2f\n",desk[i].getSellPrice());
//                    }
                       
                    System.out.println(desk);
    }
    
    /**
     * Prints laptop price, brand, and cost.
     * @param lCounter the amount of laptops in inventory
     * @param lap the array of laptops that hold inventory
     */
    public static void printLaptop(int lCounter, Laptops[] lap)
    {
                    System.out.println(lCounter + " Laptop Computer(s): ");
                    System.out.println("Brand:\t\tCost:\t\tSale Price:");
                    for (int i = 0; i < lCounter ; i++)
                    {
     
                    System.out.print(lap[i].getBrand() + "\t\t");
                    System.out.printf("$%.2f\t\t",lap[i].getCost());
                    System.out.printf("$%.2f\n",lap[i].getSellPrice());
                    }
                    System.out.println();
    }
    
    /**
     * Prints cellphone brand, cost, sale price.
     * @param cpCounter the amount of cellphones in inventory
     * @param cp the inventory that holds the cellphones
     */
    public static void printCellPhone(int cpCounter, CellPhones[] cp)
    {
                    System.out.println(cpCounter + " Cell Phone(s): ");
                    System.out.println("Brand:\t\tCost:\t\tSale Price:");
                    for (int i = 0; i < cpCounter ; i++)
                    {
     
                    System.out.print(cp[i].getBrand() + "\t\t");
                    System.out.printf("$%.2f\t\t",cp[i].getCost());
                    System.out.printf("$%.2f\n",cp[i].getSellPrice());
                    }
                    System.out.println();
    }
    
    /**
     * Makes sure user inputs proper processor info.
     * @param kb the Scanner inputs user info
     * @param proc String processor info
     * @return proc the processor info
     */
    public static String processorValidation(Scanner kb, String proc){
             while (proc.equalsIgnoreCase("i3")==false  || proc.equalsIgnoreCase("i3")==false || proc.equalsIgnoreCase("i3")==false)
                    if (proc.equalsIgnoreCase("i3") || proc.equalsIgnoreCase("i5") || proc.equalsIgnoreCase("i7")){
                        break;
                    }
                    else{
                        System.out.print("Please choose between a i3, i5, or i7 Processor: ");
                        proc = kb.nextLine();
                    }
                    
             return proc;
}
    /**
     * 
     * @param kb the Scanner inputs user info
     * @param ram integer  info 
     * @return new ram info
     */
    public static int ramValidation(Scanner kb, int ram){
         while (ram != 4 || ram != 6 || ram != 8){
                if (ram == 4 || ram == 6 || ram == 8){
                   break;
                }
            else{
            System.out.println("Please pick between 4, 6, or 8 Gigabytes: ");
            ram = kb.nextInt();            
            }
        }
         return ram;
    }
    //ensures memory is only between 32, 54 and 256
    public static int cellMemoryValidation(Scanner kb, int memory){
         
        while (memory != 32 || memory != 64 || memory != 256){
            if (memory == 32 || memory == 64 || memory == 256){
             break;
             }
             else{
             System.out.println("Please pick between 32, 64, or 256 Gigabytes: ");
             memory = kb.nextInt();            
             }
            }
        return memory;
    }
    //ensure cost is less than the selling price
    public static double priceValidation(Scanner kb, double cost, double price){
        while (cost > price){
            if (price > cost)
                break;
            System.out.println("Enter a selling price that is greater than the cost... Enter a price greater than: $" + cost);
            System.out.print("Enter a price: ");
            price = kb.nextDouble();
        }
        
        return price;
    }
    
    

}

    


