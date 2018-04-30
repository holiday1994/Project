/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
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
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CreateEmployeeGUI {
    
    GridPane pane;
    Stage primaryStage;
    
    Label lblWelEmployee;
    Label lblFirstName;
    Label lblLastName;
    Label lblEmployeeSelect;
    Label lblPrimary;
    
    
    TextField txtFirstName;
    TextField txtLastName;
    
    Button btnCreateEmp;
    
    TextField txtPrimary;
    
    RadioButton rdoCreate;
    RadioButton rdoEdit;
    RadioButton rdoDelete;
    
    
    
    ComboBox employeeCombo;
    
    ImageView employeeImage;
    
    TextArea txtAemp;
    Object sourceScreen;
    
    int counter = 1;
    String jobDesc;
    
    public CreateEmployeeGUI(Object sourceScreen){
        
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);
        
        lblWelEmployee = new Label("Hello Admin, Create Employee");
        lblFirstName = new Label("Enter First Name:");
        lblLastName = new Label("Enter Last Name:");
        lblEmployeeSelect = new Label("Choose Employee");
        
        txtFirstName = new TextField();
        txtLastName = new TextField();
        
        lblPrimary = new Label("Primary Key");
        
        btnCreateEmp = new Button("Execute ->");
        
        ToggleGroup controlToggle = new ToggleGroup();
        
        rdoCreate = new RadioButton("Create");
        rdoEdit = new RadioButton("Edit");
        rdoDelete = new RadioButton("Delete");
        
        rdoCreate.setToggleGroup(controlToggle);
        rdoEdit.setToggleGroup(controlToggle);
        rdoDelete.setToggleGroup(controlToggle);
        
        txtAemp = new TextArea();
        
        txtPrimary = new TextField();
        
        employeeImage = new ImageView(new Image("file:src/Project/images/employees.png"));
        employeeImage.setFitHeight(150);
        employeeImage.setFitWidth(250);
        
        
        
        
        ObservableList olEmployeeType = FXCollections.observableArrayList("Admin","Sales Floor","Warehouse","Sales");
        
        employeeCombo = new ComboBox(olEmployeeType);
        
        pane.add(employeeImage,1,0,3,1);
        pane.add(lblWelEmployee,0,0);
        pane.add(lblFirstName,0,1);
        pane.add(txtFirstName,1,1);
        pane.add(lblLastName,0,2);
        pane.add(txtLastName,1,2);
       
        pane.add(employeeCombo,1,3);
        pane.add(lblEmployeeSelect,0,3);
        
        pane.add(btnCreateEmp,0,6);
        
        pane.add(rdoCreate,0,4);
        pane.add(rdoEdit,1,4);
        pane.add(rdoDelete,2,4);
        
        pane.add(txtAemp,0,5,4,1);
                
        pane.add(lblPrimary,0,8);
        pane.add(txtPrimary,0,9);
        
        this.sourceScreen = sourceScreen;
        
        
        Scene scene = new Scene(pane,550,600);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Creation");
        primaryStage.show();
        

        btnCreateEmp.setOnAction(e -> {
        	
        	//get employee job description
        	if (employeeCombo.getSelectionModel().getSelectedIndex() == 0) {
        		jobDesc = "Admin";
        	} else if (employeeCombo.getSelectionModel().getSelectedIndex() == 1) {
        		jobDesc = "Sales Floor";
        	} else if (employeeCombo.getSelectionModel().getSelectedIndex() == 2) {
        		jobDesc = "Warehouse";
        	} else if (employeeCombo.getSelectionModel().getSelectedIndex() == 3) {
        		jobDesc = "Sales";
        	}
        	
        	if (rdoCreate.isSelected()) {
        		try {
        			insertItem();
        		} catch (SQLException ex) {
        			Logger.getLogger(CreateEmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        		}
        	} else if (rdoEdit.isSelected()) {
        		editItem();
        	} else if (rdoDelete.isSelected()) {
        		deleteItem();
        	}
        	
        });
  
    }
    
    public void insertItem() throws SQLException
    {
    	DatabaseStuff db = new DatabaseStuff();
    	//counter stuff
    	String sqlQuery = "insert into javauser.User (userID, firstName, lastName, jobDescription) Values (";
    	sqlQuery += counter++ + ",";
    	sqlQuery += "\'" + txtFirstName.getText() + "\',";
    	sqlQuery += "\'" + txtLastName.getText() + "\',";
    	sqlQuery += "\'" + jobDesc + "\'";
    	sqlQuery += ")";
    	
    	db.sendDBCommand(sqlQuery);
    }
    
  //update item in database based on its PK
    public void editItem()
     {
         //update JavaUser.cellphone set brand = 'bob' where cellphoneid = 1;
         String sqlQuery = "update javauser.User set firstName = ";
               
        sqlQuery += "\'" + txtFirstName.getText() + "\'," + " lastName = ";
        sqlQuery += "\'" + txtLastName.getText() + "\'," + " jobDescription = " + jobDesc;// +  "\'," + where userId = " + txtUpdate.getText() + "";         
        sqlQuery += "";
        DatabaseStuff db = new DatabaseStuff();
                
                //System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);
               
     }
    
    public void deleteItem()
    {
        String sqlQuery = "delete from javauser.User where userID = ";
        //sqlQuery += "" + txtUpdate.getText() + "" ;
                DatabaseStuff db = new DatabaseStuff();
               
               //System.out.println(sqlQuery);
              db.sendDBCommand(sqlQuery);
    }
    
    
    
}
