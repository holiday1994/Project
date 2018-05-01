/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
This CDF will display the 1st screen shown to users


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


public class BetterBuyUI extends Application {
    
    GridPane pane;
    Button btnProduct;
    Button btnEmployee;
    
    Label lblWelcome;
    Label lblEmployee;
    Label lblProduct;
    
    
    @Override
    public void start(Stage primaryStage) {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);
        
        btnProduct = new Button("Prodcuts");
        btnEmployee = new Button("Employees");
        lblWelcome = new Label("Welcome to Better Buy");
        lblEmployee = new Label("Click to Manage to Employees");
        lblProduct = new Label("Click to Manage Products");
        
        
        
        
        pane.add(lblWelcome, 0,0,1,1);
        
        pane.add(lblProduct,0,1);
        pane.add(btnProduct,1,1);
        pane.add(lblEmployee,0,2);
        pane.add(btnEmployee,1,2);
        
        
        Scene scene = new Scene(pane,300,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Better Buy System");
        primaryStage.show();
        
        //Open the Inventory
        btnProduct.setOnAction ( e -> {
           
            new InventoryUI(this);
        });
                
    }

    /**
     * @param args the command line arguments
     */
 //   public static void main(String[] args) {
  //      launch(args);
  /// }
    
//}

