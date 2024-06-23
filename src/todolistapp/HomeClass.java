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
public class HomeClass {
    Connection conn;
    
    public Connection connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "121212");
            System.out.println("Connection successful");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed. Error message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void addToDoData(String enter) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("Connection is not established.");
                return;
            }

            String query = "INSERT INTO newdos (newlists) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, enter);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserted Successfully");
            } else {
                System.out.println("Insert Failed!!");
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed!!");
            e.printStackTrace();
        }
    }
     public void deleteToDoData(String taskToDelete){
                try{
                    if(conn==null|| conn.isClosed()){
                        System.out.println("Connection is not established");
                        return;
                    }
                    String query="DELETE FROM newdos WHERE newlists=?";
                     PreparedStatement pstmt = conn.prepareStatement(query);
                     pstmt.setString(1, taskToDelete);
                     int rowsDleteted=pstmt.executeUpdate();
                     if(rowsDleteted > 0){
                         System.out.println("Deleted Successfully");
                     }
                     else{
                         System.out.println("Deleted failed: Task not found!!");
                     }
                
              
                } catch(SQLException e){
                    System.out.println("Delete Failed!!");
                        e.printStackTrace();
                }
     }
    
     
     
public void updateData(String oldId, String newId) {
    try {
        String query = "UPDATE newdos SET newlists = ? WHERE newlists = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, newId);
        pstmt.setString(2, oldId);
        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Database Update Successful");
        } else {
            System.out.println("Database Update failed: No rows affected");
        }
        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Database Update Failed!");
        e.printStackTrace();
    }
}
     
       public void listToDoData(String enter) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("Connection is not established.");
                return;
            }

            String query = "INSERT INTO newdos (newlists) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, enter);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserted Successfully");
            } else {
                System.out.println("Insert Failed!!");
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed!!");
            e.printStackTrace();
        }
    }
       public void listdeleteToDoData(String taskToDelete){
                try{
                    if(conn==null|| conn.isClosed()){
                        System.out.println("Connection is not established");
                        return;
                    }
                    String query="DELETE FROM newdos WHERE newlists=?";
                     PreparedStatement pstmt = conn.prepareStatement(query);
                     pstmt.setString(1, taskToDelete);
                     int rowsDleteted=pstmt.executeUpdate();
                     if(rowsDleteted > 0){
                         System.out.println("Deleted Successfully");
                     }
                     else{
                         System.out.println("Deleted failed: Task not found!!");
                     }
                
              
                } catch(SQLException e){
                    System.out.println("Delete Failed!!");
                        e.printStackTrace();
                }
     }
      public void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Connection closed successfully");
        }
    }


          
           

          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
      /*    
       public void listupdateToDoData(String selectedRow, String newValue) {
    try {
        if (conn == null || conn.isClosed()) {
            System.out.println("Connection is not established.");
            return;
        }

        String query = "UPDATE newdo SET newlist=? WHERE uniqueIdentifier=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, newValue);
        pstmt.setString(2, selectedRow);

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Update Successful");
        } else {
            System.out.println("Update failed: Task not found!");
        }

        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Update Failed!");
        e.printStackTrace();
    }
}
*/
            /* public void updateToDoData(String uniqueIdentifier, String newValue){
         try{
             if(conn==null || conn.isClosed()){
                 System.out.println("Connection is not established.");
                 return;
             }
             String query= "UPDATE newdo SET newlist=? WHERE uniqueIdentifier=?";
             PreparedStatement pstmt= conn.prepareStatement(query);
             pstmt.setString(1, newValue);
             pstmt.setString(2, uniqueIdentifier);
             int rowsUpdated= pstmt.executeUpdate();
             if(rowsUpdated > 0){
                 System.out.println("Update Successfully");
             }else{
                 System.out.println("Update failed: Task not found !!");
             }
         }catch(SQLException e){
             System.out.println("Update Failed !!");
             e.printStackTrace();
         }
     }*/
       
          
          
          
          
          /*
        public void personaltodo(String enter) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("Connection is not established.");
                return;
            }

            String query = "INSERT INTO personaldo (newpPersonallist) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, enter);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserted Successfully");
            } else {
                System.out.println("Insert Failed!!");
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed!!");
            e.printStackTrace();
        }
    }
           public void personaldeleteToDoData(String taskToDelete){
                try{
                    if(conn==null|| conn.isClosed()){
                        System.out.println("Connection is not established");
                        return;
                    }
                    String query="DELETE FROM personaldo WHERE newpPersonallist=?";
                     PreparedStatement pstmt = conn.prepareStatement(query);
                     pstmt.setString(1, taskToDelete);
                     int rowsDleteted=pstmt.executeUpdate();
                     if(rowsDleteted > 0){
                         System.out.println("Deleted Successfully");
                     }
                     else{
                         System.out.println("Deleted failed: Task not found!!");
                     }
                
              
                } catch(SQLException e){
                    System.out.println("Delete Failed!!");
                        e.printStackTrace();
                }
     }
            public void personalupdateToDoData(String newpPersonallist, String newValue){
         try{
             if(conn==null || conn.isClosed()){
                 System.out.println("Connection is not established.");
                 return;
             }
             String query= "UPDATE personaldo SET newValue=? WHERE newpPersonallist=?";
             PreparedStatement pstmt= conn.prepareStatement(query);
             pstmt.setString(1, newValue);
             pstmt.setString(2, newpPersonallist);
             int rowsUpdated= pstmt.executeUpdate();
             if(rowsUpdated > 0){
                 System.out.println("Update Successfully");
             }else{
                 System.out.println("Update failed: Task not found !!");
             }
         }catch(SQLException e){
             System.out.println("Update Failed !!");
             e.printStackTrace();
         }
     }
        public void worktodo(String enter) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("Connection is not established.");
                return;
            }

            String query = "INSERT INTO Workdoo (newWorkllist) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, enter);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserted Successfully");
            } else {
                System.out.println("Insert Failed!!");
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed!!");
            e.printStackTrace();
        }
    }
           public void workdeleteToDoData(String taskToDelete){
                try{
                    if(conn==null|| conn.isClosed()){
                        System.out.println("Connection is not established");
                        return;
                    }
                    String query="DELETE FROM Workdoo WHERE newWorkllist=?";
                     PreparedStatement pstmt = conn.prepareStatement(query);
                     pstmt.setString(1, taskToDelete);
                     int rowsDleteted=pstmt.executeUpdate();
                     if(rowsDleteted > 0){
                         System.out.println("Deleted Successfully");
                     }
                     else{
                         System.out.println("Deleted failed: Task not found!!");
                     }
                
              
                } catch(SQLException e){
                    System.out.println("Delete Failed!!");
                        e.printStackTrace();
                }
     }
            public void workupdateToDoData(String newWorkllist, String newValue){
         try{
             if(conn==null || conn.isClosed()){
                 System.out.println("Connection is not established.");
                 return;
             }
             String query= "UPDATE Workdoo SET Workdoo=? WHERE newWorkllist=?";
             PreparedStatement pstmt= conn.prepareStatement(query);
             pstmt.setString(1, newValue);
             pstmt.setString(2, newWorkllist);
             int rowsUpdated= pstmt.executeUpdate();
             if(rowsUpdated > 0){
                 System.out.println("Update Successfully");
             }else{
                 System.out.println("Update failed: Task not found !!");
             }
         }catch(SQLException e){
             System.out.println("Update Failed !!");
             e.printStackTrace();
         }
     }
*/
}
 