
package Project;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WareHouseViewUI {
    
    GridPane pane;
    
    Label lblWelcome;
    Label lblWarehouse;
    
    Button btnCreate;
    Button btnViewLimited;
   
    
    Stage primaryStage;
    Object sourceScreen;
    
public WareHouseViewUI(Object sourceScreen){
     
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);
        
        lblWarehouse = new Label("Warehouse View");
        lblWelcome = new Label("Welcome to the Warehouse");
        btnCreate = new Button("Create Product");
        btnViewLimited = new Button("View Products");
        
        pane.add(lblWarehouse,0,0);
        pane.add(lblWelcome,0,1);
        pane.add(btnCreate,0,2);
        pane.add(btnViewLimited,1,2);
        
        this.sourceScreen = sourceScreen;
        
        Scene scene = new Scene(pane,300,200);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin View");
        primaryStage.show();
              
        
        btnViewLimited.setOnAction(e -> {
            new ViewProductsLimited(this);
        });
        
        
        
    }
}
