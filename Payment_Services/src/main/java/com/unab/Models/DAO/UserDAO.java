
package com.unab.Models.DAO;

import com.unab.DB.*;
import com.unab.Entities.*;

import java.sql.*;
import javax.swing.*;

public class UserDAO {
    
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    int LogIn(User user){
        
        int confirmation = 0;
        String query = "";
        
        try {
            
            
            
         
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
        
        return confirmation;
        
    }
    
}
