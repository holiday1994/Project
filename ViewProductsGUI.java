
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


public class ViewProductsGUI {
    Label lblViewReports;
    
    
    CheckBox chkDisDesk;
    CheckBox chkDisLap;
    CheckBox chkDisCell;
    
    Button btnDisplay;
    
    TextArea textADis;
    
    Label lblViewProfits;
    
    CheckBox chkProfDesk;
    CheckBox chkProfLap;
    CheckBox chkProfCell;
    
    Button btnProfits;
    
    TextArea textAProf;
    
    GridPane pane;
    Scene primaryScene;
    
    Stage stage;
    
    Object sourceScreen;
    
public ViewProductsGUI(Object sourceScreen){
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
    
    //Profit Report Section
    lblViewProfits = new Label("View Profitability Report");
    
    chkProfDesk = new CheckBox("Desktop Profits");
    chkProfLap = new CheckBox("Laptop Profits");
    chkProfCell = new CheckBox("Cellphone Profits");
    
    
    btnProfits = new Button("View Capital Gains");
    textAProf = new TextArea();
    
    //add to pane
    
    pane.add(lblViewReports,0,1);
    pane.add(chkDisDesk,0,2);
    pane.add(chkDisLap,0,3);
    pane.add(chkDisCell,0,4);
    pane.add(btnDisplay,0,5);
    
    pane.add(textADis,1,1,3,1);
    
    pane.add(lblViewProfits,0,6);
    pane.add(chkProfDesk,0,7);
    pane.add(chkProfLap,0,8);
    pane.add(chkProfCell,0,9);
    pane.add(btnProfits,0,10);
    
    pane.add(textAProf,1,6,3,1);
    
    this.sourceScreen = sourceScreen;
    
    primaryScene = new Scene (pane,700,600);
    stage = new Stage();
    stage.setTitle("Product View");
    stage.setScene(primaryScene);
    stage.show();
        

}
       
    
}
