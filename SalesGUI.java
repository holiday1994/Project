
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
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class SalesGUI {
    
    GridPane pane;
    ImageView salesImage;
    Button btnShopping;
    Button btnView;
    Label lblWelcomeSales;
    Object sourceScreen;    
    Stage primaryStage;
    
    
public SalesGUI(Object sourceScreen){
    pane = new GridPane();
    pane.setHgap(5);
    pane.setVgap(5);
    pane.setAlignment(Pos.CENTER);
    
    ImageView salesImage = new ImageView(new Image("file:src/Project/images/sales.png"));
    salesImage.setFitHeight(150);
    salesImage.setFitWidth(150);
    
    
    
    lblWelcomeSales = new Label("Welcome to Sales");
    btnShopping = new Button("View Carts ->");
    
    btnView = new Button("View Products ->");
    
    
    
    pane.add(salesImage,0,1);
    pane.add(lblWelcomeSales,0,2);
    pane.add(btnShopping,0,3);
    pane.add(btnView,0,4);
    
    btnView.setOnAction (e -> {
        new ViewProductsGUI(this);

    });
    
        Scene scene = new Scene(pane,300,350);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sales View");
        primaryStage.show();
              

}
            
    
    
}
