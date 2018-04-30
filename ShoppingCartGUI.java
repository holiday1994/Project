/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
 */
package Project;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ShoppingCartGUI {
    
Stage stage;
Scene primaryScene;
    
GridPane pane;
    
TextArea txtADesk;
TextArea txtALap;
TextArea txtACell;
TextArea txtCart;


Label lblDesktxt;
Label lblLaptxt;
Label lblCelltxt;

Label lblUID;

TextField txtUID;

Button btnAddCart;
Button btnSendIt;

RadioButton rdoDesk;
RadioButton rdoLap;
RadioButton rdoCell;

ImageView betterImage;
ImageView cartImage;

Object sourceScreen;

public ShoppingCartGUI(Object sourceScreen){
    pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(7);
    pane.setVgap(7);
    
    betterImage = new ImageView(new Image ("file:src/Project/images/BetterBuy.png"));
        betterImage.setFitWidth(150);
        betterImage.setFitHeight(100);
    
    txtADesk = new TextArea();
    txtALap = new TextArea();
    txtACell = new TextArea();
    txtCart = new TextArea();
    
    lblDesktxt= new Label("Desktops");
    lblLaptxt = new Label("Laptops");
    lblCelltxt = new Label("Cell Phones:");
    
    lblUID = new Label("Unique ID");
    
    btnAddCart = new Button("Add to Cart");
    btnSendIt = new Button("Finished Cart");
    
    rdoDesk = new RadioButton("Desktop");
    rdoLap = new RadioButton("Laptop");
    rdoCell = new RadioButton("Cell Phone");
    
    txtUID = new TextField();
    
    ToggleGroup toggle = new ToggleGroup();
        rdoDesk.setToggleGroup(toggle);
        rdoLap.setToggleGroup(toggle);
        rdoCell.setToggleGroup(toggle);
        
        
     pane.add(lblDesktxt,0,0);
     pane.add(txtADesk,0,1,1,2);
     pane.add(lblLaptxt,0,3);
     pane.add(txtALap,0,4,1,3);
     
     pane.add(lblCelltxt,0,7);
     pane.add(txtACell,0,8,1,3);
     
     pane.add(betterImage,1,2,3,1);
     pane.add(lblUID,1,3);
     
     pane.add(txtUID,1,4,2,1);
     
     pane.add(rdoDesk,1,5);
     pane.add(rdoLap,2,5);
     pane.add(rdoCell,3,5);
     
     pane.add(btnAddCart,1,9);
     pane.add(btnSendIt,2,9);
     
     pane.add(txtCart,1,6,3,3);
     
     this.sourceScreen = sourceScreen;
     
     
    primaryScene = new Scene (pane,1300,900);
    stage = new Stage();
    stage.setTitle("Shopping Cart");
    stage.setScene(primaryScene);
    stage.show();
     
     
     
                
    
    
    
    
    
    
    
    
    
    
}
        
        
        

    
    

    
    
}
