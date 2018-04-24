package Project;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InventoryUI {

    //create references here so it can be accessed
    Label objType;
    Button btnCreate;
    Button btnDisplay;
    Button btnExpense;
    ComboBox comboType;

    ImageView image = new ImageView();

    GridPane pane;

    Stage primaryStage;

    BetterBuyUI sourceScreen;

    File file;
    Image imageURL;

    public InventoryUI(BetterBuyUI sourceScreen) {

        //Adding Gridpane
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);

        //Adding new widgets 
        objType = new Label("Select Product Type ");
        btnCreate = new Button("Create Product");
        btnDisplay = new Button("Display Products");
        btnExpense = new Button("Show Expense Report");

        ObservableList listType = FXCollections.observableArrayList("Desktop", "Laptop", "Cellphone");

        comboType = new ComboBox(listType);

        image.setFitHeight(100);
        image.setFitWidth(100);

        //Adding onto the pane
        pane.add(objType, 0, 0);
        pane.add(comboType, 1, 0, 1, 1);
        pane.add(btnCreate, 0, 1, 1, 1);
        pane.add(btnDisplay, 0, 2, 1, 1);
        pane.add(btnExpense, 1, 2);
        pane.add(image, 0, 3, 2, 1);

        //Display pane on scene, and scene onto the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage = new Stage();
        primaryStage.setTitle("Better Buy Inventory Application");
        primaryStage.setScene(scene);
        primaryStage.show();

        this.sourceScreen = sourceScreen;

        btnCreate.setOnAction(e -> {

            //Opens the Desktop UI
            if (comboType.getSelectionModel().getSelectedIndex() == 0) {
                new DesktopGUI(this);
            }
            if (comboType.getSelectionModel().getSelectedIndex() == 1) {
                new LaptopGUI(this);
            }
            if (comboType.getSelectionModel().getSelectedIndex() == 2) {
                new CellPhoneGUI(this);
            }

        });

        comboType.setOnAction(e -> {
            Object item = comboType.getValue();

            if (item.equals("Cellphone")) {
                imageURL = new Image("file:src/Project/images/Cellphone.jpg");
                image.setImage(imageURL);
            }
            
            if(item.equals("Desktop")) {
                imageURL = new Image("file:src/Project/images/Desktop.jpg");
                image.setImage(imageURL);
            }
            
            if(item.equals("Laptop")) {
                imageURL = new Image("file:src/Project/images/Laptop.jpg");
                image.setImage(imageURL);
            }
        });

    }
}
