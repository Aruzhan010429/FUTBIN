package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static Connection connection;
    public  String  dbHost= "localhost";
protected  String dbPort="3306";
protected  String dbUser ="root";
protected  String dbPass="";
protected  String dbName="futbin";


    public DBManager() {

    }

    public  Connection connection() throws ClassNotFoundException, SQLException {
      String connectionString ="jdbc:mysql//"+dbHost + ":"+dbPort+"/"
              +dbName;
      Class.forName("com.mysql.jdbc.Driver");
      connection=DriverManager.getConnection(connectionString,dbUser,dbPass);
      return connection;
    }
}


