
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
    
    TextField txtFirstName;
    TextField txtLastName;
    
    Button btnCreateEmp;
    
    ComboBox employeeCombo;
    
    ImageView employeeImage;
    
    
    
   
    
    Object sourceScreen;
    
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
        
        btnCreateEmp = new Button("Create ->");
        
        employeeImage = new ImageView(new Image("file:src/Project/images/employees.png"));
        employeeImage.setFitHeight(150);
        employeeImage.setFitWidth(250);
        
        
        
        
        ObservableList olEmployeeType = FXCollections.observableArrayList("Admin","Sales Floor","Warehouse","Sales");
        
        employeeCombo = new ComboBox(olEmployeeType);
        
        pane.add(employeeImage,1,0);
        pane.add(lblWelEmployee,0,0);
        pane.add(lblFirstName,0,1);
        pane.add(txtFirstName,1,1);
        pane.add(lblLastName,0,2);
        pane.add(txtLastName,1,2);
       
        pane.add(employeeCombo,1,3);
        pane.add(lblEmployeeSelect,0,3);
        
        pane.add(btnCreateEmp,0,4);
        
        
        this.sourceScreen = sourceScreen;
        
        
        Scene scene = new Scene(pane,550,380);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Creation");
        primaryStage.show();
        

        
        
    }
    
    
    
    
    
}
