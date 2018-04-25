/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author KimKim
 */
public class BetterBuyLogin extends Application {
    Label lblWelcome;
    ComboBox userCombo;
    Label lblSelectUser;
    Button btnContinue;
    ImageView betterPic;
    GridPane pane;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        
        pane.setVgap(5);
        pane.setHgap(5);
        
        lblWelcome = new Label("Welcome to Better Login");
        
        lblSelectUser = new Label("Please Select User Type:");
        
        
        ObservableList olUserList =  FXCollections.observableArrayList("Admin","Sales Floor","Warehouse","Sales");
        userCombo = new ComboBox(olUserList);
        btnContinue = new Button("Continue -->");
        
        pane.add(lblWelcome,0,1);
        pane.add(lblSelectUser,0,2);
        pane.add(userCombo,1,2);
        
        pane.add(btnContinue,0,3);
        
        
       btnContinue.setOnAction (e -> {
        if(userCombo.getSelectionModel().getSelectedIndex() == 0){
              new AdminViewGUI(this);
        }
       
       
       if(userCombo.getSelectionModel().getSelectedIndex() == 1 ){
              new ViewProductsLimited(this);
       }
        
       if(userCombo.getSelectionModel().getSelectedIndex() == 2){
              new WareHouseViewUI(this);
       }
       
       if(userCombo.getSelectionModel().getSelectedIndex() == 3){
           
       }
       
       });
       
       
        Scene scene = new Scene(pane,300,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Better Buy Login Page");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
