/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
 */
package Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

public class DatabaseStuff {

    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    ResultSetMetaData rsmd;

    public static void main(String[] args) {
        DatabaseStuff stuff = new DatabaseStuff();
        stuff.createTable();
    }

    public void createTable() {
        String sqlCellphone = "Create Table Cellphone (cellphoneId integer primary key, "
                + "brand varchar(100), "
                + "cost varchar(100),"
                + "sellPrice varchar(100),"
                + "screensize integer,"
                + "memory integer,"
                + "type varchar(100))"
                + "shoppingCart integer";

        String sqlDesktop = "Create Table Desktop (desktopId integer primary key, "
                + "brand varchar(100), "
                + "cost varchar(100),"
                + "sellPrice varchar(100),"
                + "processor varchar(100),"
                + "hardDriveSize integer,"
                + "ram integer,"
                + "type varchar(100)),"
                + "shoppingCart integer";

        String sqlLaptop = "Create Table Laptop(laptopId integer primary key, "
                + "brand varchar(100), "
                + "cost varchar(100),"
                + "sellPrice varchar(100),"
                + "processor varchar(100),"
                + "hardDriveSize integer,"
                + "ram integer,"
                + "screensize integer,"
                + "backlit varchar(100),"
                + "fingerprintReader varchar(100),"
                + "type varchar(100))"
                 + "shoppingCart integer";

        sendDBCommand(sqlCellphone);
        sendDBCommand(sqlDesktop);
        sendDBCommand(sqlLaptop);
        
        String sqlUser = "Create Table Users (userID integer primary key,"
                + "firstname varchar(100),"
                + "lastname varchar(100),"
                + "privillege varChar(100),"
                + "jobdescription varchar(100))";
    
               
        
        sendDBCommand(sqlUser);
        
         String sqlShoppingCart = "Create Table cart (cartid integer primary key,"
                + "firstname varchar(100),"
                + "lastname varchar(100),"
                + "cellphone integer,"
                + "pk integer,"
                 + "brand varchar(100),"
                + "type varChar(100),"
                + "SellPrice integer)";
                

        
        sendDBCommand(sqlShoppingCart);
        String insertCP1 = "INSERT ALL \n";
        insertCP1 += "into javauser.CellPhone (cellPhoneId, brand, cost, sellPrice, screensize, memory, type) Values (3,'Samsung','199','299',6,64,'Cell Phone')\n";
        insertCP1 += "into javauser.CellPhone (cellPhoneId, brand, cost, sellPrice, screensize, memory, type) Values (4,'Apple','299','898',6,64,'Cell Phone')\n";
        insertCP1 += "into javauser.CellPhone (cellPhoneId, brand, cost, sellPrice, screensize, memory, type) Values (5,'Nokia','99','199',6,64,'Cell Phone')\n";
        insertCP1 += "into javauser.CellPhone (cellPhoneId, brand, cost, sellPrice, screensize, memory, type) Values (6,'Apple','399','999',6,64,'Cell Phone')\n";
        insertCP1 += "into javauser.CellPhone (cellPhoneId, brand, cost, sellPrice, screensize, memory, type) Values (7,'Google','199','399',6,64,'Cell Phone')\n";
        insertCP1 += "Select * from dual";
        sendDBCommand(insertCP1);
        String insertDT1 = "insert into javauser.Desktop (desktopId, brand, cost, sellPrice, processor, hardDriveSize, ram, type) Values (2,'Alienware','1199','2200','i7',256,8,'Desktop')";
        String insertDT2 = "insert into javauser.Desktop (desktopId, brand, cost, sellPrice, processor, hardDriveSize, ram, type) Values (2,'MSI','600','1400','i5',1000,16,'Desktop')";
        String insertDT3 = "insert into javauser.Desktop (desktopId, brand, cost, sellPrice, processor, hardDriveSize, ram, type) Values (2,'IBUYPOWER','2200','4000','i7',1000,16,'Desktop')";  
        String insertDT5 = "insert into javauser.Desktop (desktopId, brand, cost, sellPrice, processor, hardDriveSize, ram, type) Values (3,'Dell','199','499','i3',128,4,'Desktop')";
    
    }
    
   
    public String getMaxPK(String pkColumn, String tableName) throws SQLException
    {
       //ResultSet rs = null;
       //DatabaseStuff db = new DatabaseStuff();
        
       String PK = "select max(";
      PK += "" + pkColumn + ") from javauser." + tableName
              + "";
       sendDBCommand(PK);
       String pk = "";
       while (dbResults.next())
       {

        pk = dbResults.getString("Max(" + pkColumn
                + ")");
        System.out.println(pk);
       }
       
       if (pk == null)
           pk = "0";
            
       
       return pk;
    }
    int count = 0;


    public void sendDBCommand(String sqlQuery) {

        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser"; // Change to YOUR Oracle username
        String userPASS = "javapass"; // Change to YOUR Oracle password
        OracleDataSource ds;

        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);

        // Lets try to connect
        try {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID, userPASS);
            // When we get results
            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
            //   will see our resultset update in real time.
            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
            //   data in our database by using the .update____() methods of
            //   the ResultSet class - TableView controls are impacted by
            //   this setting as well.
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // We send the query to the DB. A ResultSet object is instantiated
            //  and we are returned a reference to it, that we point to from
            // dbResults.
            // Because we declared dbResults at the datafield level
            // we can see the results from anywhere in our Class.
            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
            // The results are stored in a ResultSet structure object
            // pointed to by the reference variable dbResults
            // Because we declared this variable globally above, we can use
            // the results in any method in the class.
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
