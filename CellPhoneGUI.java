
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

public class CellPhoneGUI {
    
    Label cellWelcome;
    Label lblBrand;
    Label lblSellPrice;
    Label lblCost;
    Label lblMemory;
    Label lblScreenSize;
    
    TextField txtBrand;
    TextField txtSellPrice;
    TextField txtCost;
    
    RadioButton rdo36;
    RadioButton rdo64;
    RadioButton rdo256;
    
    ComboBox screenCombo;
    Button createButton;
    TextArea txtACell;
    
    
    InventoryUI sourceScreen;
    
    GridPane pane;
    
    Scene primaryScene;
    Stage primaryStage;
    
    
    public CellPhoneGUI(InventoryUI sourceScreen){
        
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);
        
        //Label instantiation
        
        
        cellWelcome = new Label("CellPhone Creation");
        
        //Brand 
        lblBrand = new Label("Enter the Brand");
        txtBrand = new TextField();
        
        //Combo box for Screen Size
        lblScreenSize = new Label ("Select the Screen Size");
        ObservableList scrnList =  FXCollections.observableArrayList("4 Inches","5 Inches ","6 Inches"
                ,"7 Inches","8 Inches");
        screenCombo = new ComboBox (scrnList);
        
        //Memory 
        lblMemory = new Label("Choose Cell Memory");
        rdo36 = new RadioButton("36");
        rdo64 = new RadioButton("64");
        rdo256 = new RadioButton("256");
        
        //cost
        lblCost = new Label("Enter Cost");
        txtCost = new TextField();
        
        //Sell Price
        lblSellPrice = new Label("Enter Price");
        txtSellPrice = new TextField();
        
        //Create and TextArea
        createButton = new Button("Create");
        txtACell = new TextArea();
        
        // Adding all Widets to the pane
        
        pane.add(cellWelcome,0,0);
        
        //Brand
        pane.add(lblBrand, 0,1);
        pane.add(txtBrand,1,1);
        
        //Screensize
        pane.add(lblScreenSize,0,2);
        pane.add(screenCombo,1,2);
        
        //Memory
        pane.add(lblMemory,0,3);
        pane.add(rdo36,0,4);
        pane.add(rdo64,0,5);
        pane.add(rdo256,0,6);
        
        //cost
        pane.add(lblCost,0,7);
        pane.add(txtCost,1,7);
        
        //price
        pane.add(lblSellPrice,0,8);
        pane.add(txtSellPrice,1,8);
        
        //create button & textfield
        pane.add(createButton,0,9);
        pane.add(txtACell,0,10,3,1);
        
        this.sourceScreen = sourceScreen;
        
        primaryScene = new Scene(pane,600,600);
        primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("CellPhone Creation");
        primaryStage.show();
        
        
        
        
        
        
    }
    
    
    
}
