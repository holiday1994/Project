/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
This CDF will be the UI for Desktops in which users will insert, edit, and delete inventory
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
    Label lblPK;
    
    
    TextField txtBrand;
    TextField txtSellPrice;
    TextField txtCost;
    TextField txtUpdate;
   
    RadioButton rdoi3;
    RadioButton rdoi5;
    RadioButton rdoi7;
    
    RadioButton rdo128;
    RadioButton rdo256;
    RadioButton rdo500;
    RadioButton rdo1000;
    
    ComboBox ramCombo;
    
    TextArea txtADesk;
    
    
    RadioButton rdoCreate;
    RadioButton rdoUpdate;
    RadioButton rdoDelete;
    
    
    Button btnCreateDesktop;
    
    Button btnClear;
    
    GridPane pane;
    Stage primaryStage;
    
    Object sourceScreen;
    
    Scene primaryScene;
    Stage stage;
    String proc;
    int hardDriveSize;
    int ram;
    String type = "Desktop";
    static int counter = 1;
    static int deleteTimes = 0;
 public DesktopGUI(Object sourceScreen) throws SQLException{
     
     //Set Up pane 
     pane = new GridPane();
     pane.setVgap(5);
     pane.setHgap(5);
     pane.setAlignment(Pos.CENTER);
     
     //welcome
     deskWelcome = new Label("Desktop Creation");
     lblPK = new Label ("Desktop Primary Key To Modify/Delete");
     
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
     
     
     
     rdoCreate = new RadioButton("Create");
     rdoUpdate = new RadioButton("Update");
     rdoDelete = new RadioButton("Delete");
     
     ToggleGroup sqlToggle = new ToggleGroup();
     
     rdoCreate.setToggleGroup(sqlToggle);
     rdoUpdate.setToggleGroup(sqlToggle);
     rdoDelete.setToggleGroup(sqlToggle);
     
     
     
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
     
     
     pane.add(rdoCreate,0,15);
     pane.add(rdoUpdate,1,15);
     pane.add(rdoDelete,2,15);
     pane.add(btnCreateDesktop,3,15);
     txtUpdate = new TextField();
     pane.add(txtADesk,0,16,3,1);
     pane.add(txtUpdate, 2,1);
     pane.add(lblPK,2,0);
     
    txtADesk.setText(printDesktops());
     
    primaryScene = new Scene (pane,600,600);
    stage = new Stage();
    stage.setTitle("Better Buy Desktop Creation");
    stage.setScene(primaryScene);
    stage.show();
    

    
   
 
    btnCreateDesktop.setOnAction(e -> {
       if (rdoDelete.isSelected())
			{
				//clear fields
				ramCombo.valueProperty().set(null);
				hardToggle.selectToggle(null);
				procToggle.selectToggle(null);
				txtBrand.clear();
				txtCost.clear();
				txtSellPrice.clear();
				if (txtUpdate.getText().trim().isEmpty()) 
				{
					//validate if item to delete numeric primary key is specified
					Alert pKeyAlert = new Alert(AlertType.ERROR, "Please enter Primary Key");
					pKeyAlert.showAndWait();
				} else {
					try {
						deleteItem();
						txtADesk.clear();
						txtADesk.setText(printDesktops());
					} catch (SQLException ex) {
						Logger.getLogger(DesktopGUI.class.getName()).log(Level.SEVERE, null, ex);
					}
				}                 
			}else if (rdoUpdate.isSelected() || rdoCreate.isSelected())
			{
				//validate if form is filled
				if (txtBrand.getText().trim().isEmpty() || txtCost.getText().trim().isEmpty() || 
						txtSellPrice.getText().trim().isEmpty() || (!rdoi3.isSelected() && !rdoi5.isSelected()
								&& !rdoi7.isSelected()) ||(!rdo128.isSelected() && !rdo256.isSelected() && !rdo500.isSelected()
										&& !rdo1000.isSelected()) ||ramCombo.getSelectionModel().isEmpty()) 
				{
					//display alert if form is unfilled
					Alert formAlert = new Alert(AlertType.ERROR, "Please fill out the form");
					formAlert.showAndWait();
				} else {

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
					//check if create or update is selected
					if (rdoCreate.isSelected()) {
						try {
							insertItem();
							txtADesk.clear();
							txtADesk.setText(printDesktops());
						} catch(SQLException ex) {
							Logger.getLogger(DesktopGUI.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else {
						if (txtUpdate.getText().trim().isEmpty()) {
							//if numerical primary key is not specified, Alert
							Alert pKeyAlert = new Alert(AlertType.ERROR, "Please enter Primary Key");
							pKeyAlert.showAndWait(); 
						}else {
							try {
								updateItem();
								txtADesk.clear();
								txtADesk.setText(printDesktops());
							} catch (SQLException ex) {
								Logger.getLogger(DesktopGUI.class.getName()).log(Level.SEVERE, null, ex);
							}

						}
					} 
				} 
			}
			else {
				//Makes user select database action (create, update, delete)
				Alert rdoAlert = new Alert(AlertType.ERROR, "Please select Create, Update, or Delete.");
				rdoAlert.showAndWait();
			}




		});
	}
     public void insertItem() throws SQLException
    {
        DatabaseStuff db = new DatabaseStuff();
        //counter is the PK of the desktop table and must be unique even after app is closed and re-opened
        counter = Integer.valueOf(db.getMaxPK("desktopid", "desktop")) + 1;
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
        
                        //desktop.setCount(db.getRows("Desktop"));

                //System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);
                              
    }
     public void updateItem() throws SQLException
     {
         String sqlQuery = "update javauser.Desktop set brand = ";
               
        sqlQuery += "\'" + txtBrand.getText() + "\'," + " cost = ";
        sqlQuery += "\'" + txtCost.getText() + "\'," + " sellprice = ";
        sqlQuery += "\'" + txtSellPrice.getText() + "\'," + " processor = ";
        sqlQuery += "\'" + proc + "\'," + " hardDriveSize = ";
        sqlQuery += "" + hardDriveSize + "," + " ram = ";
        sqlQuery += "" + ram + "," + " type = ";
        sqlQuery += "\'" + type + "\'" + " where desktopId = " + txtUpdate.getText() + "";         
        sqlQuery += "";
        DatabaseStuff db = new DatabaseStuff();
                
                System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);

     }
     //delete desktop item
     public void deleteItem() throws SQLException
     {
         String sqlQuery = "delete from javauser.Desktop where desktopId = ";
         sqlQuery += "" + txtUpdate.getText() + "" ;
                 DatabaseStuff db = new DatabaseStuff();
              
                //System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);

     }

   
     //print desktops to txt area
    public String printDesktops() throws SQLException{
        DatabaseStuff db = new DatabaseStuff();
        String printAll = "Select * from Desktop";
        db.sendDBCommand(printAll);
        String command = "";
        System.out.println("IM HERE");
        db.rsmd = db.dbResults.getMetaData();
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            
            command+= String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-20s%-5s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(2) ,"Sell Price: ", db.dbResults.getNString(4) , "Cost: " , db.dbResults.getNString(3)
                    , "Processor: " , db.dbResults.getNString(5) , "Hard Drive :" , db.dbResults.getNString(6) 
                    , "Ram :" , db.dbResults.getNString(7));
                  
        }
        
        return command;
    }
     
}

    


    

 

    


    

