/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author ashin
 */
public class dbconnection {
    
    Connection conn;
    
    public Connection connect() {
    
    try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","121212");
                        System.out.println("Connection successful");
			return conn;
	
	}
	catch (SQLException e) {
        System.out.println("Connection failed. Error message: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
    }



    
  


    
    
    
    
    
    
    
    
    
    
    
    
    
    
      public void addToDoData(String enter){
            try{
                
                
                Statement stmt = conn.createStatement();
                    String Query = "INSERT INTO newList(Newdata) VALUES ('"+enter+"');"; 
                   stmt.executeUpdate(Query);
                   System.out.println("Inserted Successfully");
}
               catch(SQLException e){
                  System.out.println("Insert Failed!!");

            }
      }
}