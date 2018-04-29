
package Project;

import java.util.ArrayList;


public class ShoppingCart {
    
    ArrayList <Product> cartList;
    
    String firstName;
    String lastName;
    
    String phoneNumber;
    
    static double tax;

    double total;
    
    public ShoppingCart(String firstName, 
        String lastName, String phoneNumber){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        
        
        
    }
    
    
    
    
}
