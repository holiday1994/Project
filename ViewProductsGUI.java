/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
 */
package Project;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    //add to pane
    
    pane.add(lblViewReports,0,1);
    pane.add(chkDisDesk,0,2);
    pane.add(chkDisLap,0,3);
    pane.add(chkDisCell,0,4);
    pane.add(btnDisplay,0,5);
    
    pane.add(textADis,1,1,3,1);
    
    
    this.sourceScreen = sourceScreen;
    
    primaryScene = new Scene (pane,700,600);
    stage = new Stage();
    stage.setTitle("Product View");
    stage.setScene(primaryScene);
    stage.show();
        
    //print either desktop, laptop, or cell phones or a combination to text area
    btnDisplay.setOnAction(e -> {
        textADis.clear();
    if (chkDisDesk.isSelected())
    {
        try {
            textADis.appendText("DESKTOPS:\n");
            textADis.appendText(printDesktops());
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    if (chkDisLap.isSelected())
    {
        try {
            textADis.appendText("LAPTOPS:\n");
            textADis.appendText(printLaptops());
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    if (chkDisCell.isSelected())
    {
            try {
                textADis.appendText("CELL PHONES:\n");
                textADis.appendText(printCellPhones());
            } catch (SQLException ex) {
                Logger.getLogger(ViewProductsGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    }
    });
    
}

       public String printDesktops() throws SQLException{
        DatabaseStuff db = new DatabaseStuff();
        String printAll = "Select * from Desktop";
        db.sendDBCommand(printAll);
        String command = "";
        System.out.println("IM HERE");
        db.rsmd = db.dbResults.getMetaData();
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            
            command+= String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-20s%-5s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(2) ,"Sell Price: ", db.dbResults.getNString(4) , "Cost: " , db.dbResults.getNString(3)
                    , "Processor: " , db.dbResults.getNString(5) , "Hard Drive :" , db.dbResults.getNString(6) 
                    , "Ram :" , db.dbResults.getNString(7));
                  
        }
        
        return command;
    }    
    
       
         public String printLaptops() throws SQLException{
        DatabaseStuff db = new DatabaseStuff();
        String printAll = "Select * from Laptop";
        db.sendDBCommand(printAll);
        String command = "";
        System.out.println("IM HERE");
        db.rsmd = db.dbResults.getMetaData();
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            
            command+= String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-5s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(2) ,"Sell Price: ", db.dbResults.getNString(4) , "Cost: " , db.dbResults.getNString(3)
                    , "Processor: " , db.dbResults.getNString(5) , "Hard Drive :" , db.dbResults.getNString(6) 
                    , "Ram :" , db.dbResults.getNString(7) , "Screen Size: " , db.dbResults.getNString(8) , "Backlit : ", db.dbResults.getNString(9) , 
                    "Fingerprint Reader : " , db.dbResults.getNString(10));
                  
        }
        
        return command;
    }
         
        public String printCellPhones() throws SQLException{
        DatabaseStuff db = new DatabaseStuff();
        String printAll = "Select * from cellphone";
        db.sendDBCommand(printAll);
        String command = "";
        System.out.println("IM HERE");
        db.rsmd = db.dbResults.getMetaData();
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            
            command+= String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s%-5s%-20s%-5s%-20s%-5s%n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(2) ,"Sell Price: ", db.dbResults.getNString(4) , "Cost: " , db.dbResults.getNString(3)
                    ,"Screen Size: " , db.dbResults.getNString(5) , "Memory : ", db.dbResults.getNString(6));
                  
        }
        
        return command;
    }
    
}
