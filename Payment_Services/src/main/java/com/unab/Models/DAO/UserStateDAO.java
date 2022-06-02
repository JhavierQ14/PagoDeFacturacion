package com.unab.Models.DAO;

import com.unab.Entities.UserState;
import com.unab.DB.ConnectionDB;

import java.util.*;
import java.sql.*;
import javax.swing.*;

public class UserStateDAO {

    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public ArrayList<UserState> ReadUserState(){
        
        ArrayList<UserState> listUserS = new ArrayList<UserState>();
        String query = "SELECT * FROM pago_de_facturacion_db.user_state;";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                
                UserState userS = new UserState();
                userS.setId_user_state(rs.getInt("id_user_state"));
                userS.setUser_state_name(rs.getString("user_state_name"));
                listUserS.add(userS);
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        
        return listUserS;
    }
}
