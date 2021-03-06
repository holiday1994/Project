/*
author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
This CDF displays the GUI for cell-phones in which users will interact with
*/
package Project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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
    TextField txtUpdate;
    RadioButton rdo36;
    RadioButton rdo64;
    RadioButton rdo256;
        
    ComboBox screenCombo;
    Button createButton;
    Button btnClear;
    TextArea txtACell;
    
    RadioButton rdoCreate;
    RadioButton rdoUpdate;
    RadioButton rdoDelete;
    Label lblCPPK;
    
    
    Object sourceScreen;
    
    GridPane pane;
    
    Scene primaryScene;
    Stage primaryStage;
    
    int memStorage;
    int screenSize;
    
    int counter = 1;
    String type = "Cell Phone";
    
    
    public CellPhoneGUI(Object sourceScreen) throws SQLException{
        
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
        
        //toggle memory radio button
        ToggleGroup rdoMemory = new ToggleGroup();
        
        rdo36.setToggleGroup(rdoMemory);
        rdo64.setToggleGroup(rdoMemory);
        rdo256.setToggleGroup(rdoMemory);
        
        rdoCreate = new RadioButton("Create");
        rdoUpdate = new RadioButton("Update");
        rdoDelete = new RadioButton("Delete");
     
        ToggleGroup sqlToggle = new ToggleGroup();
     
        rdoCreate.setToggleGroup(sqlToggle);
        rdoUpdate.setToggleGroup(sqlToggle);
        rdoDelete.setToggleGroup(sqlToggle);
        
        //cost
        lblCost = new Label("Enter Cost");
        txtCost = new TextField();
        txtUpdate = new TextField();
        lblCPPK = new Label("Cellphone Primary Key To Modify/Delete");
        
        //Sell Price
        lblSellPrice = new Label("Enter Price");
        txtSellPrice = new TextField();
        
        //Create and TextArea
        createButton = new Button("Create");
        txtACell = new TextArea();
        
        // Adding all Widets to the pane
        
        pane.add(cellWelcome,0,0);
        pane.add(lblCPPK, 2, 0);
        pane.add(txtUpdate,2,1);
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
        pane.add(rdoCreate,0,9);
        pane.add(rdoUpdate,1,9);
        pane.add(rdoDelete,2,9);
        pane.add(createButton,3,9);
        pane.add(txtACell,0,10,3,1);
        txtACell.setText(printCellPhones());
        
        this.sourceScreen = sourceScreen;
        
        primaryScene = new Scene(pane,600,600);
        primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("CellPhone Creation");
        primaryStage.show();
        
        //the "textfield".getText().trim().isEmpty() comes from StackOverflow:
        //https://stackoverflow.com/questions/32866937/how-to-check-if-textfield-is-empty
        
        //Allows users to create 
	        createButton.setOnAction(e -> {
if (rdoDelete.isSelected()) {
				//clear fields
				txtBrand.clear();
				screenCombo.valueProperty().set(null);
				rdoMemory.selectToggle(null);
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
						txtACell.clear();
						txtACell.setText(printCellPhones());
					} catch (SQLException ex) {
						Logger.getLogger(CellPhoneGUI.class.getName()).log(Level.SEVERE, null, ex);
					}
				}                 
			} else if (rdoUpdate.isSelected() || rdoCreate.isSelected())
			{

				//validate
				if(txtBrand.getText().trim().isEmpty() || (!rdo36.isSelected() && !rdo64.isSelected() && !rdo256.isSelected())
						|| screenCombo.getSelectionModel().isEmpty() || txtCost.getText().trim().isEmpty() || 
						txtSellPrice.getText().trim().isEmpty()) {
					//display alert if form is unfilled
					Alert formAlert = new Alert(AlertType.ERROR, "Please fill out the form");
					formAlert.showAndWait();
				} else {


					//get screen size from combo box
					if (screenCombo.getSelectionModel().getSelectedIndex() == 0) {
						screenSize = 4;
					} else if (screenCombo.getSelectionModel().getSelectedIndex() == 1) {
						screenSize = 5;
					} else if (screenCombo.getSelectionModel().getSelectedIndex() == 2) {
						screenSize = 6;
					} else if (screenCombo.getSelectionModel().getSelectedIndex() == 3) {
						screenSize = 7;
					} else if (screenCombo.getSelectionModel().getSelectedIndex() == 4) {
						screenSize = 8;
					}

					//get memory from radio buttons
					if (rdo36.isSelected()) {
						memStorage = 36;
					} else if (rdo64.isSelected()) {
						memStorage = 64;
					} else if (rdo256.isSelected()) {
						memStorage = 256;
					}

						//check if create or update is selected
						if (rdoCreate.isSelected()) {
							try {
								insertItem();
								txtACell.clear();
								txtACell.setText(printCellPhones());
							} catch(SQLException ex) {
								Logger.getLogger(CellPhoneGUI.class.getName()).log(Level.SEVERE, null, ex);
							}
						} else {
							if (txtUpdate.getText().trim().isEmpty()) {
								//if numerical primary key is not specified, Alert
								Alert pKeyAlert = new Alert(AlertType.ERROR, "Please enter Primary Key");
								pKeyAlert.showAndWait(); 
						}else {								try {
									updateItem();
									txtACell.clear();
									txtACell.setText(printCellPhones());
								} catch (SQLException ex) {
									Logger.getLogger(CellPhoneGUI.class.getName()).log(Level.SEVERE, null, ex);
								}

							}
						} 
					} 
				
			}
			else {
				//Makes user select database action (create, update, delete)
				Alert rdoAlert = new Alert(AlertType.ERROR, "Please select Create, Update, or delete.");
				rdoAlert.showAndWait();
			}

		});


	}
    //create item and read into database
    public void insertItem() throws SQLException
    {
        DatabaseStuff db = new DatabaseStuff();
        counter = Integer.valueOf(db.getMaxPK("cellphoneid", "cellphone")) + 1;
    	String sqlQuery = "insert into javauser.CellPhone (cellPhoneId, brand, cost, sellPrice, screensize, memory, type) Values (";
    	sqlQuery += counter++ + ",";
    	sqlQuery += "\'" + txtBrand.getText() + "\',";
    	sqlQuery += "\'" + txtCost.getText() + "\',";
    	sqlQuery += "\'" + txtSellPrice.getText() + "\',";
    	sqlQuery += "" + screenSize + ",";
    	sqlQuery += "" + memStorage + ",";
    	sqlQuery += "\'" + type + "\'";
    	sqlQuery += ")";
    	
    	
    	db.sendDBCommand(sqlQuery);
    }
    //update item in database based on its PK
    public void updateItem()
     {
         //update JavaUser.cellphone set brand = 'bob' where cellphoneid = 1;
         String sqlQuery = "update javauser.CellPhone set brand = ";
               
        sqlQuery += "\'" + txtBrand.getText() + "\'," + " cost = ";
        sqlQuery += "\'" + txtCost.getText() + "\'," + " sellprice = ";
        sqlQuery += "\'" + txtSellPrice.getText() + "\'," + " screensize = ";
        sqlQuery += "" + screenSize + "," + " memory = ";
        sqlQuery += "" + memStorage + "," + " type = ";
        sqlQuery += "\'" + type + "\'" + " where cellPhoneId = " + txtUpdate.getText() + "";         
        sqlQuery += "";
        DatabaseStuff db = new DatabaseStuff();
                
                //System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);
               
     }
        //delete item through the use of its PK
         public void deleteItem()
     {
         String sqlQuery = "delete from javauser.cellphone where cellphoneid = ";
         sqlQuery += "" + txtUpdate.getText() + "" ;
                 DatabaseStuff db = new DatabaseStuff();
                
                //System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);
     }
    
        //Print cell Phones to text area      
        public String printCellPhones() throws SQLException{
        DatabaseStuff db = new DatabaseStuff();
        String printAll = "Select * from cellphone";
        db.sendDBCommand(printAll);
        String command = "";
        System.out.println("IM HERE");
        db.rsmd = db.dbResults.getMetaData();
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            
            command+= String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-5s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(2) ,"Sell Price: ", db.dbResults.getNString(4) , "Cost: " , db.dbResults.getNString(3)
                    ,"Screen Size: " , db.dbResults.getNString(5) , "Memory : ", db.dbResults.getNString(6));
                  
        }
        
        return command;
    }
    
}
