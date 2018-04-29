/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
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
    
    ImageView betterImage;
    ImageView usaImage;

    
    //DatabaseStuff db = new DatabaseStuff();

    DatabaseStuff db = new DatabaseStuff();

    Desktop desktop = new Desktop();
    
    
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        
        
        
        
       //desktop.setCount(db.getRows("Desktop"));
        
        
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        
        pane.setVgap(5);
        pane.setHgap(5);
        
        betterImage = new ImageView(new Image("file:src/Project/images/BetterBuy.png"));
        betterImage.setFitWidth(150);
        betterImage.setFitHeight(100);
        
        usaImage = new ImageView(new Image("file:src/Project/images/USA.png"));
        usaImage.setFitWidth(200);
        usaImage.setFitHeight(100);
        

        lblWelcome = new Label("Welcome to Better Buy Login");
        
        lblSelectUser = new Label("Please Select User Type:");
      
        
        
        ObservableList olUserList =  FXCollections.observableArrayList("Admin","Sales Floor","Warehouse","Sales");
        userCombo = new ComboBox(olUserList);
        btnContinue = new Button("Continue -->");
        
        pane.add(lblWelcome,0,2);
        pane.add(usaImage,1,0,1,2);
        pane.add(betterImage,0,0,2,1);
        pane.add(lblSelectUser,0,3);
        pane.add(userCombo,1,3);
        
        pane.add(btnContinue,0,4);
        
        
       btnContinue.setOnAction (e -> {
        if(userCombo.getSelectionModel().getSelectedIndex() == 0){
              new AdminViewGUI(this);
        }
       
       
       if(userCombo.getSelectionModel().getSelectedIndex() == 1 ){
          new ViewProductsLimited(this);
       }
        
       if(userCombo.getSelectionModel().getSelectedIndex() == 2){
           //WareHouseViewGUI needs implementing   
    	  new WareHouseViewUI(this);
       }
       
       if(userCombo.getSelectionModel().getSelectedIndex() == 3){
          new SalesGUI(this);
       }
       
       });
       
        Scene scene = new Scene(pane,450,250);
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
