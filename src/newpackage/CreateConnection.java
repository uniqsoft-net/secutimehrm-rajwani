/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

    
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Connection;  
  
public class CreateConnection {  
  
 // defining driver name, mysql-jdbc driver in this case  
 String driverName = "com.mysql.jdbc.Driver";  
 Connection con = null;  
  
 // database url string with hostname and port on which db is running  
 
  String url="jdbc:mysql://localhost:3306/hrm";
        String username="root";
        String password="";
 public Connection getConnection( String username,  
   String password) {  
  
  // creating connection url  
  String connectionUrl = url;  
  
  try {  
   // registers the specified driver class into memory  
   Class.forName(driverName);  
  } catch (ClassNotFoundException e) {  
   e.printStackTrace();  
  }  
  
  try {  
   // returns a connection objcet by selecting an appropriate driver  
   // for specified connection URL  
   con = DriverManager  
     .getConnection(connectionUrl, username, password);  
  } catch (SQLException e) {  
   e.printStackTrace();  
  }  
  return con;  
 }}
