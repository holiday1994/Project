/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




public class ViewProductsLimited {
    
    Label lblViewReports;
    
    
    CheckBox chkDisDesk;
    CheckBox chkDisLap;
    CheckBox chkDisCell;
    
    Button btnDisplay;
    
    TextArea textADis;
    
    GridPane pane;
    Scene primaryScene;
    Stage stage;
    Object sourceScreen;
    
    
public ViewProductsLimited(Object sourceScreen){

    pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(5);
    pane.setVgap(5);
    
    lblViewReports = new Label("View Reports");
    chkDisDesk = new CheckBox("View Desktop");
    chkDisLap = new CheckBox("View Laptop");
    chkDisCell = new CheckBox("View Cellphone");
    
    btnDisplay = new Button("Display Products");
    textADis = new TextArea();
    
    pane.add(lblViewReports,0,1);
    pane.add(chkDisDesk,0,2);
    pane.add(chkDisLap,0,3);
    pane.add(chkDisCell,0,4);
    pane.add(btnDisplay,0,5);
    
    pane.add(textADis,1,1,3,1);
    
    this.sourceScreen = sourceScreen;
    
    primaryScene = new Scene (pane,700,400);
    stage = new Stage();
    stage.setTitle("Product View");
    stage.setScene(primaryScene);
    stage.show();
    
    
    
    
}
    
}
