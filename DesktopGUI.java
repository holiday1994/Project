
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


public class DesktopGUI {
    
    Label deskWelcome;
    Label lblBrand;
    Label lblSellPrice;
    Label lblCost;
    Label lblProcessor;
    Label lblHardDrive;
    Label lblRam;
    
    TextField txtBrand;
    TextField txtSellPrice;
    TextField txtCost;
   
    RadioButton rdoi3;
    RadioButton rdoi5;
    RadioButton rdoi7;
    
    RadioButton rdo128;
    RadioButton rdo256;
    RadioButton rdo500;
    RadioButton rdo1000;
    
    ComboBox ramCombo;
    
    TextArea txtADesk;
    
    Button btnCreateDesktop;
    
    Button btnClear;
    
    GridPane pane;
    Stage primaryStage;
    
    InventoryUI sourceScreen;
    
    Scene primaryScene;
    Stage stage;
    String proc;
    int hardDriveSize;
    int ram;
    String type = "Desktop";
    int counter = 1;
    
 public DesktopGUI(InventoryUI sourceScreen){
     
     //Set Up pane 
     pane = new GridPane();
     pane.setVgap(5);
     pane.setHgap(5);
     pane.setAlignment(Pos.CENTER);
     
     //welcome
     deskWelcome = new Label("Desktop Creation");
     
     //Brand
     lblBrand = new Label ("Please Enter the Brand");
     txtBrand = new TextField();
   
     //Processor
     lblProcessor = new Label("Choose the Processor");
     
     //RDO for Processors 
     rdoi3 = new RadioButton("i3");
     rdoi5 = new RadioButton("i5");
     rdoi7 = new RadioButton("i7");
     
     //RDO toggle group
     ToggleGroup procToggle = new ToggleGroup();
     
     rdoi3.setToggleGroup(procToggle);
     rdoi5.setToggleGroup(procToggle);
     rdoi7.setToggleGroup(procToggle);
     
     //RadioButtons for HardDrive
     lblHardDrive = new Label("Choose a Hard Drive");
     rdo128 = new RadioButton("128 GB");
     rdo256 = new RadioButton("256 GB");
     rdo500 = new RadioButton("500 GB");
     rdo1000 = new RadioButton("1000 GB");
     
     ToggleGroup hardToggle = new ToggleGroup();
     
     rdo128.setToggleGroup(hardToggle);
     rdo256.setToggleGroup(hardToggle);
     rdo500.setToggleGroup(hardToggle);
     rdo1000.setToggleGroup(hardToggle);
     
     //Ram Combo Box
     lblRam = new Label("Please Select Ram Type");
     ObservableList olRam =  FXCollections.observableArrayList("4 GB","6 GB","8 GB","16 GB");
     ramCombo = new ComboBox(olRam);
     
     
     //Cost + Price Widgets
     lblCost = new Label("Enter Cost");
     txtCost = new TextField();
     
     lblSellPrice = new Label("Enter Price");
     txtSellPrice = new TextField();
     
     btnCreateDesktop = new Button("Create");
     btnClear = new Button("Clear");
     
     txtADesk = new TextArea();
     
     this.sourceScreen = sourceScreen;

     
     //Adding Widgets to pane
     pane.add(deskWelcome,0,0);
     
     pane.add(lblBrand,0,1);
     pane.add(txtBrand,1,1);
     
     pane.add(lblProcessor,0,2);
     pane.add(rdoi3,0,3);
     pane.add(rdoi5,0,4);
     pane.add(rdoi7,0,5);
     
     pane.add(lblHardDrive,0,6);
     pane.add(rdo128,0,7);
     pane.add(rdo256,0,8);
     pane.add(rdo500,0,9);
     pane.add(rdo1000,0,10);
     
     pane.add(lblRam,0,11);
     pane.add(ramCombo,1,11);
     
     pane.add(lblCost,0,13);
     pane.add(txtCost,1,13);
     
     pane.add(lblSellPrice,0,14);
     pane.add(txtSellPrice,1,14);
     
     pane.add(btnCreateDesktop,0,15);
     
     pane.add(txtADesk,0,16,3,1);
     
     
    primaryScene = new Scene (pane,600,600);
    stage = new Stage();
    stage.setTitle("Better Buy Desktop Creation");
    stage.setScene(primaryScene);
    stage.show();
    

    
    
   
 
    btnCreateDesktop.setOnAction(e -> {
          //get ram from combo box

     if (ramCombo.getSelectionModel().getSelectedIndex() == 0) {
                this.ram = 4;
            } else if (ramCombo.getSelectionModel().getSelectedIndex() == 1) {
                ram = 6;
            } else if (ramCombo.getSelectionModel().getSelectedIndex() == 2) {
                ram = 8;
            } else if (ramCombo.getSelectionModel().getSelectedIndex() == 3) {
                ram = 16;
            }
  
    //get info from 
    if (rdo128.isSelected())
        hardDriveSize = 128;
    else if (rdo256.isSelected())
        hardDriveSize = 256;
    else if (rdo500.isSelected())
        hardDriveSize = 500;
    else if (rdo1000.isSelected())
        hardDriveSize = 1000;
    else {
        hardDriveSize = 1;}
     //get info from processor toggle radio buttons
    if (rdoi3.isSelected())
        proc = "i3";
    else if (rdoi5.isSelected())
        proc = "i5";
    else if (rdoi7.isSelected())
        proc = "i7";
    else {
        proc = "idk";}  
if (rdoCreate.isSelected())
{
     insertItem();
}
if (rdoUpdate.isSelected())
{
    updateItem();
    
    
    
}
 });
    
  }
     public void insertItem()
    {
        
        
        String sqlQuery = "insert into javauser.Desktop (desktopId, brand, cost, sellPrice, processor, hardDriveSize, ram, type) Values (";
        sqlQuery += counter++ + ",";
        sqlQuery += "\'" + txtBrand.getText() + "\',";
        sqlQuery += "\'" + txtCost.getText() + "\',";
        sqlQuery += "\'" + txtSellPrice.getText() + "\',";
        sqlQuery += "\'" + proc + "\',";
        sqlQuery += "" + hardDriveSize + ",";
        sqlQuery += "" + ram + ",";
        sqlQuery += "\'" + type + "\'";              
        sqlQuery += ")";
        DatabaseStuff db = new DatabaseStuff();
                
                //System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);
               
    }
     public void updateItem()
     {
         String sqlQuery = 'update javauser.Desktop (
     }
}
 

    


    

