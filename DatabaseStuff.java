/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                + "type varchar(100))";

        String sqlDesktop = "Create Table Desktop (desktopId integer primary key, "
                + "brand varchar(100), "
                + "cost varchar(100),"
                + "sellPrice varchar(100),"
                + "processor varchar(100),"
                + "hardDriveSize integer,"
                + "ram integer,"
                + "type varchar(100))";

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
                + "type varchar(100))";

        sendDBCommand(sqlCellphone);
        sendDBCommand(sqlDesktop);
        sendDBCommand(sqlLaptop);
        
        String sqlUser = "Create Table Users (userID integer primary key,"
                + "userName varchar(100),"
                + "canEdit varchar(100),"
                + "canDelete varchar(100),"
                + "canCreate varchar(100),"
                + "canView varchar(100),"
                + "canCreateShoppingCart varchar(100),"
                + "canAdminUsers varchar(100))";
        
        sendDBCommand(sqlUser);

                

    }
    int count = 0;
    public int getRows(String table) throws SQLException
    {
        String sql = "Select * from " + table;
        sendDBCommand(sql);     
        
        while(dbResults.next()){
            count++;
        }
        
              return count;
        
    }
    public void incrimentCount()
    {
        count += 2;
    }
    

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
