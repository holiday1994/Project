package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class AdminViewGUI {
    
    GridPane pane;
    Button btnProduct;
    Button btnEmployee;
    
    Label lblWelcome;
    Label lblEmployee;
    Label lblProduct;
    
    Stage primaryStage;
    
    BetterBuyLogin sourceScreen;
    
    
    
   public AdminViewGUI(BetterBuyLogin sourceScreen){
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);
        
        btnProduct = new Button("Prodcuts");
        btnEmployee = new Button("Employees");
        lblWelcome = new Label("Welcome to Admin View");
        lblEmployee = new Label("Click to Manage to Employees");
        lblProduct = new Label("Click to Manage Products");
        
       
        pane.add(lblWelcome, 0,0,1,1);
        
        pane.add(lblProduct,0,1);
        pane.add(btnProduct,1,1);
        pane.add(lblEmployee,0,2);
        pane.add(btnEmployee,1,2);
        
        
        this.sourceScreen = sourceScreen;
        
        Scene scene = new Scene(pane,500,500);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin View");
        primaryStage.show();
        
        //Open the Inventory
        btnProduct.setOnAction ( e -> {
         new InventoryUI(this);
            
        });
                
    }
}

