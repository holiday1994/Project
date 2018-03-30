package Project;

/*
author: Stavros Kontzias
date: 2/27/18
purpose: Better Buy Prototype Inventory Mangement System
 */
//package project;
import java.util.Scanner;
public class inventoryApp {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        desktop[] desk = new desktop[1000];
        CellPhones[] cp = new CellPhones[1000];
        laptops[] lap = new laptops[1000];
        Object[] inv = new Object[1000];

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
                    System.out.println("Please enter the Processor of the Desktop: ");
                    String proc = kb.next();                   
                    System.out.println("Please enter the Hard Drive Size of the Desktop: ");
                    int hdd = kb.nextInt();
                    System.out.println("Please enter the RAM of the Desktop: ");
                    int ram = kb.nextInt();
                    System.out.println("Please enter the Cost of the Desktop: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Desktop: ");
                    double price = kb.nextDouble();
                    desktop a = new desktop(brand, proc, hdd, ram, cost, price);
                    inv[0] = new desktop(brand, proc, hdd, ram, cost, price);
                    desk[dCounter] = new desktop(brand, proc, hdd, ram, cost, price);
                    dCounter++;  
                    break;
                }
                case 2://write into Laptop
                {
                    System.out.println("Please enter the brand of the Laptop: ");
                    String brand = kb.next();
                    System.out.println("Please enter the Processor of the Laptop: ");
                    String proc = kb.next();
                    System.out.println("Please enter the Hard Drive Size of the Laptop: ");
                    int hdd = kb.nextInt();
                    System.out.println("Please enter the RAM of the Laptop: ");
                    int ram = kb.nextInt();
                    System.out.println("Please enter the Cost of the Laptop: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Laptop: ");
                    double price = kb.nextDouble();
                    System.out.println("Please enter the Screen Size of the Laptop: ");
                    String screen = kb.next();
                    System.out.println("Is the keyboard backlit? (Y/N)");
                    String backlight = kb.next();
                    System.out.println("Is there a fingerprint reader? (Y/N) ");
                    String fingerPrint = kb.next();
                    laptops newPC = new laptops(brand, proc, hdd, ram, cost, price, screen, backlight, fingerPrint);
                    lap[lCounter] = new laptops(brand, proc, hdd, ram, cost, price, screen, backlight, fingerPrint);
                    lCounter++;
                    break;
                }
                case 3://write into CellPhones
                {
                    System.out.println("Please enter the brand of the Cell Phone: ");
                    String brand = kb.next();
                    System.out.println("Please enter the Screen Size of the Cell Phone: ");
                    String screen = kb.next();
                    System.out.println("Please enter the Memory of the Cell Phone: ");
                    int memory = kb.nextInt();
                    System.out.println("Please enter the Cost of the Cell Phone: ");
                    double cost = kb.nextDouble();
                    System.out.println("Please enter the Selling price of the Cell Phone: ");
                    double price = kb.nextDouble();
                   
                    CellPhones newPhone = new CellPhones(brand, screen, memory, cost, price);
                    cp[cpCounter] = new CellPhones(brand, screen, memory, cost, price);
                    cpCounter++;
                    break;
                }
                case 4:
                {
                    printDesktop(dCounter, desk);
                    break;
                }
                case 5:
                {
                    printLaptop(lCounter, lap);
                    break;
                }
                case 6:
                {
                    printCellPhone(cpCounter, cp);
                    break;
                }
                case 7://Print all
                {
                    printDesktop(dCounter, desk);
                    printLaptop(lCounter, lap);
                    printCellPhone(cpCounter, cp);
                    break;
                    
                }
                            
            }
        
        }
    }
        
    
    public static void printDesktop(int dCounter, desktop[] desk)
    {
                    System.out.println(dCounter + " Desktop Computer(s): ");
                    System.out.println("Brand:\t\tCost:\t\tSale Price:");
                    for (int i = 0; i < dCounter ; i++)
                    {
     
                    System.out.print(desk[i].getBrand() + "\t\t");
                    System.out.printf("$%.2f\t\t",desk[i].getPurchaseCost());
                    System.out.printf("$%.2f\n",desk[i].getSalesPrice());
                    }
                    System.out.println();
    }
    
    public static void printLaptop(int lCounter, laptops[] lap)
    {
                    System.out.println(lCounter + " Laptop Computer(s): ");
                    System.out.println("Brand:\t\tCost:\t\tSale Price:");
                    for (int i = 0; i < lCounter ; i++)
                    {
     
                    System.out.print(lap[i].getBrand() + "\t\t");
                    System.out.printf("$%.2f\t\t",lap[i].getPurchaseCost());
                    System.out.printf("$%.2f\n",lap[i].getSalesPrice());
                    }
                    System.out.println();
    }
    
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
    
}

