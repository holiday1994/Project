
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
    
    ComboBox productCombo;
   
    
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
        
        ObservableList olProducts = FXCollections.observableArrayList("Desktop","Laptop","Cellphone");
        productCombo = new ComboBox(olProducts);
        
        
        
        
        pane.add(lblWarehouse,0,0);
        pane.add(lblWelcome,0,1);
        pane.add(productCombo,0,2);
        pane.add(btnCreate,1,2);
        pane.add(btnViewLimited,0,3);
        
        this.sourceScreen = sourceScreen;
        
        Scene scene = new Scene(pane,400,400);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Warehouse View");
        primaryStage.show();
              
        
        btnViewLimited.setOnAction(e -> {
            new ViewProductsLimited(this);
        });
        
        btnCreate.setOnAction( e -> {
            if (productCombo.getSelectionModel().getSelectedIndex() == 0) {
                new DesktopGUI(this);
            }
            if (productCombo.getSelectionModel().getSelectedIndex() == 1) {
                new LaptopGUI(this);
            }
            if (productCombo.getSelectionModel().getSelectedIndex() == 2) {
                new CellPhoneGUI(this);
            }
          
        });
        
        
    }
}
