
package com.unab.Models.DAO;

import com.unab.DB.*;
import com.unab.Entities.*;

import java.sql.*;
import javax.swing.*;

public class UserDAO {
    
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public int LogIn(User user){
        
        int confirmation = 0;
        String query = "{call pago_de_facturacion_db.SP_VALIDATION_USER(?,?,?)}";
        
        try {
            
            
             CallableStatement Consul = connection.prepareCall(query);
             Consul.setString("PUsername", user.getUser_Name());
             Consul.setString("PEmail",  user.getEmail());
             Consul.setString("Ppass",  user.getPassword());
            
            ResultSet rs = Consul.executeQuery();
            if (rs.next()) {
                
                confirmation = 1;
                return  confirmation;
                
          }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
        
        return confirmation;
        
    }
    
}
