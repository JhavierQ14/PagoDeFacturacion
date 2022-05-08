package com.unab.Models.DAO;

import com.unab.DB.*;
import com.unab.Entities.*;
import com.unab.Domain.*;

import java.sql.*;
import javax.swing.*;

public class UserDAO {

    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();

    public int LogIn(User user) {

        int confirmation = 0;
        String query = "{call pago_de_facturacion_db.SP_VALIDATION_USER(?,?,?)}";

        try {

            CallableStatement qry = connection.prepareCall(query);
            qry.setString("PUsername", user.getUser_Name());
            qry.setString("PEmail", user.getEmail());
            qry.setString("Ppass", user.getPassword());

            ResultSet rs = qry.executeQuery();
            if (rs.next()) {

                confirmation = 1;
                return confirmation;
            }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }

        return confirmation;
    }
    
    public void CreateUser(User user){
        
        String query = "{call pago_de_facturacion_db.SP_C_USER(?,?,?,?,?)}";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_user_state_id", user.getUser_State_id());
            cs.setString("p_user_name", user.getUser_Name());
            cs.setString("p_email", user.getEmail());
            cs.setString("p_password", user.getPassword());
            cs.setString("p_perfil_image", user.getPerfil_image());
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
    }

}
