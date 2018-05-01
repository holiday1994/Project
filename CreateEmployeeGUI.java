/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
This allows the admin to create, edit, or delete employees
 */
package Project;

import static Project.DesktopGUI.counter;
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
    TextField txtPrimary;
    
    
    Button btnCreateEmp;
    
    RadioButton rdoCreate;
    RadioButton rdoEdit;
    RadioButton rdoDelete;
    
    
    
    ComboBox employeeCombo;
    
    ImageView employeeImage;
    
    TextArea txtAemp;
    Object sourceScreen;
    
    int counter = 1;
    String jobDesc;
    String jobDescription = "";
    public CreateEmployeeGUI(Object sourceScreen) throws SQLException{
        
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
        
        btnCreateEmp = new Button("Execute ->");
        
        ToggleGroup controlToggle = new ToggleGroup();
        
        rdoCreate = new RadioButton("Create");
        rdoEdit = new RadioButton("Edit");
        rdoDelete = new RadioButton("Delete");
        
        rdoCreate.setToggleGroup(controlToggle);
        rdoEdit.setToggleGroup(controlToggle);
        rdoDelete.setToggleGroup(controlToggle);
        
        txtAemp = new TextArea();
        
        
        
        
        employeeImage = new ImageView(new Image("file:src/Project/images/employees.png"));
        employeeImage.setFitHeight(150);
        employeeImage.setFitWidth(250);
        
        
        
        
        ObservableList olEmployeeType = FXCollections.observableArrayList("Admin","Sales Floor","Warehouse","Sales");
        
        employeeCombo = new ComboBox(olEmployeeType);
        
        lblPrimary = new Label("Enter E_ID to Delete or Edit");
        txtPrimary = new TextField();
        
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
        pane.add(lblPrimary,0,7);
        pane.add(txtPrimary,0,8);
        
        
                
        
        
        this.sourceScreen = sourceScreen;
        
        
        Scene scene = new Scene(pane,550,600);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Creation");
        primaryStage.show();
        txtAemp.setText(printUsers());

        
        //Creates employees depending on type through the combo box
        btnCreateEmp.setOnAction(e -> {
        	
        	//get employee job description
        	if (employeeCombo.getSelectionModel().getSelectedIndex() == 0) {
        		jobDesc = "Admin";
                        jobDescription = "View, Add, Edit, Delete";
        	} else if (employeeCombo.getSelectionModel().getSelectedIndex() == 1) {
        		jobDesc = "Sales Floor";
                        jobDescription = "View";
        	} else if (employeeCombo.getSelectionModel().getSelectedIndex() == 2) {
        		jobDesc = "Warehouse";
                        jobDescription = "View, Add, Edit, Delete";
        	} else if (employeeCombo.getSelectionModel().getSelectedIndex() == 3) {
        		jobDesc = "Sales";
                        jobDescription = "View, Shopping Cart";
        	}
        	
                
                //Determines if admin wants to Add, edit, delete
        	if (rdoCreate.isSelected()) {
        		try {
        			insertItem();
                                txtAemp.clear();
                                txtAemp.setText(printUsers());
                                
        		} catch (SQLException ex) {
        			Logger.getLogger(CreateEmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        		}
        	} else if (rdoEdit.isSelected()) {
        		editItem();
                        txtAemp.clear();
                        
                    try {
                        txtAemp.setText(printUsers());
                    } catch (SQLException ex) {
                        Logger.getLogger(CreateEmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
        	} else if (rdoDelete.isSelected()) {
        		deleteItem();
                        txtAemp.clear();
                    try {
                        txtAemp.setText(printUsers());
                    } catch (SQLException ex) {
                        Logger.getLogger(CreateEmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
        	}
        	
        });
  
    }
    
    public void insertItem() throws SQLException
    {
    	DatabaseStuff db = new DatabaseStuff();
    	counter = Integer.valueOf(db.getMaxPK("userid", "users")) + 1;
    	String sqlQuery = "insert into javauser.Users (userID, firstName, lastName, privillege, jobDescription) Values (";
    	sqlQuery += counter + ",";
    	sqlQuery += "\'" + txtFirstName.getText() + "\',";
    	sqlQuery += "\'" + txtLastName.getText() + "\',";
        sqlQuery += "\'" + jobDescription + "\',";
    	sqlQuery += "\'" + jobDesc + "\'";
    	sqlQuery += ")";
    	
    	db.sendDBCommand(sqlQuery);
    }
    
  //update item in database based on its PK
    public void editItem()
     {
         //update JavaUser.cellphone set brand = 'bob' where cellphoneid = 1;
         String sqlQuery = "update javauser.Users set firstName = ";
               
        sqlQuery += "\'" + txtFirstName.getText() + "\'," + " lastName = ";
        sqlQuery += "\'" + txtLastName.getText() + "\'," + "privillege = ";
        sqlQuery += "\'" + jobDescription + "\'," +  "jobDescription = ";
        sqlQuery += "\'" + jobDesc +  "\'" + "where userId = " + txtPrimary.getText() + "";         
        DatabaseStuff db = new DatabaseStuff();
                
                System.out.println(sqlQuery);
               db.sendDBCommand(sqlQuery);
               
     }
    
    public void deleteItem()
    {
        String sqlQuery = "delete from javauser.Users where userID = ";
        sqlQuery += "" + txtPrimary.getText() + "" ;
                DatabaseStuff db = new DatabaseStuff();
               
               //System.out.println(sqlQuery);
              db.sendDBCommand(sqlQuery);
    }
    
    public String printUsers() throws SQLException{
        DatabaseStuff db = new DatabaseStuff();
        String printAll = "Select * from users";
        db.sendDBCommand(printAll);
        String command = "";
        System.out.println("IM HERE");
        db.rsmd = db.dbResults.getMetaData();
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            
            command+= String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s\n", 
                    "E_ID:",db.dbResults.getNString(1),"First Name: "
                    ,db.dbResults.getNString(2) ,"Last name: ", db.dbResults.getNString(3) , "Privillege: " , db.dbResults.getNString(4)
                    , "\tJob Desc: " , db.dbResults.getNString(5));
                  
        }
        
        return command;
    }
    
    
    
}
