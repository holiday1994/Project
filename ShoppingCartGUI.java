/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
 */
package Project;

import static Project.DesktopGUI.counter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ShoppingCartGUI {
    
    GridPane pane;
    
TextArea txtAInventory;
Stage stage;
Scene primaryScene;

    

    
TextArea txtADesk;
TextArea txtALap;
TextArea txtACell;
TextArea txtCart;



Label lblDesktxt;
Label lblLaptxt;
Label lblCelltxt;

Label lblFirstName;
Label lblLastName;
Label lblCell;

Label lblUID;

TextField txtUID;

TextField txtFirstName;
TextField txtLastName;
TextField txtCell;

Button btnAddCart;
Button btnSendIt;

RadioButton rdoDesk;
RadioButton rdoLap;
RadioButton rdoCell;

ImageView betterImage;
ImageView cartImage;

Object sourceScreen;

public ShoppingCartGUI(Object sourceScreen) throws SQLException{
    pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(7);
    pane.setVgap(7);
    
    betterImage = new ImageView(new Image ("file:src/Project/images/BetterBuy.png"));
        betterImage.setFitWidth(150);
        betterImage.setFitHeight(100);
    
    txtADesk = new TextArea();
    txtALap = new TextArea();
    txtACell = new TextArea();
    txtCart = new TextArea();

    txtADesk.setText(printDesktops());
    txtALap.setText(printLaptops());
    txtACell.setText(printCellPhones());
    lblDesktxt= new Label("Desktops");
    lblLaptxt = new Label("Laptops");
    lblCelltxt = new Label("Cell Phones:");
    
    lblUID = new Label("Unique ID");
    
    btnAddCart = new Button("Add to Cart");
    btnSendIt = new Button("Finished Cart");
    
    rdoDesk = new RadioButton("Desktop");
    rdoLap = new RadioButton("Laptop");
    rdoCell = new RadioButton("Cell Phone");
    
    txtUID = new TextField();
    
    lblCell = new Label("CellPhone");
    lblFirstName = new Label("First Name");
    lblLastName = new Label("Last Name");
    
    txtFirstName = new TextField();
    txtLastName = new TextField();
    txtCell = new TextField();
    
    ToggleGroup toggle = new ToggleGroup();
        rdoDesk.setToggleGroup(toggle);
        rdoLap.setToggleGroup(toggle);
        rdoCell.setToggleGroup(toggle);
        
        
     pane.add(lblDesktxt,0,0);
     pane.add(txtADesk,0,1,1,2);
     pane.add(lblLaptxt,0,3);
     pane.add(txtALap,0,4,1,3);
     
     pane.add(lblCelltxt,0,7);
     pane.add(txtACell,0,8,1,3);
     
     pane.add(betterImage,1,2,3,1);
     pane.add(lblUID,1,3);
     
     pane.add(txtUID,1,4,2,1);
     
     
     
     pane.add(lblFirstName,1,5);
     pane.add(lblLastName,2,5);
     pane.add(lblCell,3,5);
     
     pane.add(txtFirstName,1,6);
     pane.add(txtLastName,2,6);
     pane.add(txtCell,3,6);
     

     
     pane.add(rdoDesk,1,7);
     pane.add(rdoLap,2,7);
     pane.add(rdoCell,3,7);
     

     pane.add(btnAddCart,1,11);
     pane.add(btnSendIt,2,11);
     pane.add(txtCart,1,8,3,3);
     
     this.sourceScreen = sourceScreen;
     

    primaryScene = new Scene (pane,1300,900);
    stage = new Stage();
    stage.setTitle("Shopping Cart");
    stage.setScene(primaryScene);
    stage.show();
    
    btnAddCart.setOnAction(e -> {
        
        
    if (rdoDesk.isSelected())
    {
       try {
            
        
            txtCart.appendText(getDesktop());
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       
    if (rdoLap.isSelected())
    {
        
        try {
            txtCart.appendText(getLaptop());
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    if (rdoCell.isSelected())
    {
        
        try {
            txtCart.appendText(getCellPhone());
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartGUI.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public String getDesktop() throws SQLException
    {
        DatabaseStuff db = new DatabaseStuff();
        String sqlQuery = "select desktopid, sellprice, brand from Desktop where desktopid = ";
        sqlQuery += txtUID.getText() + "";
        db.sendDBCommand(sqlQuery);
        String command = "";
         db.rsmd = db.dbResults.getMetaData();
         String pk;
         String brand ="";
         String sellPrice = "";
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            pk = db.dbResults.getNString(1);
            brand = db.dbResults.getNString(3);
            sellPrice = db.dbResults.getNString(2);
            command += String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(3) ,"Sell Price: ", db.dbResults.getNString(2));
    }
        counter = Integer.valueOf(db.getMaxPK("cartid", "cart")) + 1;
        String aQuery = "insert into cart (cartid, firstname, lastname, cellphone, pk, brand, type, sellprice) Values (";
        aQuery += "\'" + counter + "\',";
        aQuery += "\'" + txtFirstName.getText() + "\',";
        aQuery += "\'" + txtLastName.getText() + "\',";
        aQuery += "" + txtCell.getText() + ",";
        aQuery += "" + txtUID.getText() + ",";
        aQuery += "\'" + brand + "\',";
        aQuery += "\'" + "Desktop" + "\',";    
        aQuery += "" + sellPrice + "";
        aQuery += ")";
        
                        //desktop.setCount(db.getRows("Desktop"));

                System.out.println(aQuery);
               db.sendDBCommand(aQuery);
                              
        
        return command;
        
        
}
    
    
    
        public String getLaptop() throws SQLException
    {
        DatabaseStuff db = new DatabaseStuff();
        String sqlQuery = "select laptopid, sellprice, brand from laptop where laptopid = ";
        sqlQuery += txtUID.getText() + "";
        db.sendDBCommand(sqlQuery);
        String command = "";
         db.rsmd = db.dbResults.getMetaData();
         String pk;
         String brand ="";
         String sellPrice = "";
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            pk = db.dbResults.getNString(1);
            brand = db.dbResults.getNString(3);
            sellPrice = db.dbResults.getNString(2);
            command += String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(3) ,"Sell Price: ", db.dbResults.getNString(2));
    }
        counter = Integer.valueOf(db.getMaxPK("cartid", "cart")) + 1;
        String aQuery = "insert into cart (cartid, firstname, lastname, cellphone, pk, brand, type, sellprice) Values (";
        aQuery += "\'" + counter + "\',";
        aQuery += "\'" + txtFirstName.getText() + "\',";
        aQuery += "\'" + txtLastName.getText() + "\',";
        aQuery += "" + txtCell.getText() + ",";
        aQuery += "" + txtUID.getText() + ",";
        aQuery += "\'" + brand + "\',";
        aQuery += "\'" + "Laptop" + "\',";    
        aQuery += "" + sellPrice + "";
        aQuery += ")";
        
                        //desktop.setCount(db.getRows("Desktop"));

                System.out.println(aQuery);
               db.sendDBCommand(aQuery);
                              
        
        return command;
        
        
}
    public String getCellPhone() throws SQLException
    {
        DatabaseStuff db = new DatabaseStuff();
        String sqlQuery = "select cellphoneid, sellprice, brand from cellphone where cellphoneid = ";
        sqlQuery += txtUID.getText() + "";
        db.sendDBCommand(sqlQuery);
        String command = "";
         db.rsmd = db.dbResults.getMetaData();
         String pk;
         String brand ="";
         String sellPrice = "";
        while(db.dbResults.next()){
            //for(int i = 1; i <= db.rsmd.getRowCount(); i++)
            pk = db.dbResults.getNString(1);
            brand = db.dbResults.getNString(3);
            sellPrice = db.dbResults.getNString(2);
            command += String.format("%-15s%-15s\n%-5s%-20s%-5s%-20s\n", 
                    "Unique ID:",db.dbResults.getNString(1),"Brand: "
                    ,db.dbResults.getNString(3) ,"Sell Price: ", db.dbResults.getNString(2));
    }
        counter = Integer.valueOf(db.getMaxPK("cartid", "cart")) + 1;
        String aQuery = "insert into cellphones (cartid, firstname, lastname, cellphone, pk, brand, type, sellprice) Values (";
        aQuery += "\'" + counter + "\',";
        aQuery += "\'" + txtFirstName.getText() + "\',";
        aQuery += "\'" + txtLastName.getText() + "\',";
        aQuery += "" + txtCell.getText() + ",";
        aQuery += "" + txtUID.getText() + ",";
        aQuery += "\'" + brand + "\',";
        aQuery += "\'" + "CellPhone" + "\',";    
        aQuery += "" + sellPrice + "";
        aQuery += ")";
        
                        //desktop.setCount(db.getRows("Desktop"));

                System.out.println(aQuery);
               db.sendDBCommand(aQuery);
                              
        
        return command;
        
        
}
}
