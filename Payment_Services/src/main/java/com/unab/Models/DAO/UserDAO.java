package com.unab.Models.DAO;

import com.unab.DB.*;
import com.unab.Entities.*;
import com.unab.Domain.*;
import com.unab.Models.ViewModels.*;

import java.sql.*;
import javax.swing.*;
import java.util.*;

public class UserDAO {

    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();

    
    /* Validar Usuario*/
    public int LogIn(User user) {

        int confirmation = 0;
        String query = "{call pago_de_facturacion_db.SP_VALIDATION_USER(?,?,?)}";

        try {

            CallableStatement qry = connection.prepareCall(query);
            qry.setString("PUsername", user.getUser_Name());
            qry.setString("PEmail", user.getEmail());
            qry.setString("Ppass", user.getPassword());

            ResultSet rs = qry.executeQuery();
            if (rs.next())
            {
                UserLoginCache ulc = new UserLoginCache();
                
                
                confirmation = 1;
                return confirmation;
            }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }

        return confirmation;
    }
    
    /*Crear Usuario*/
    public void CreateUser(User user){
        
        String query = "{call pago_de_facturacion_db.SP_C_USER(?,?,?,?,?)}";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_user_state_id", user.getUser_State_id());
            cs.setString("p_user_name", user.getUser_Name());
            cs.setString("p_email", user.getEmail());
            cs.setString("p_password", user.getPassword());
            cs.setString("p_perfil_image", user.getPerfil_image());
            
            cs.executeUpdate();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
    }
    
    /* Mostrar usuario*/
    public ArrayList<UserVM> ReadUser(){
        
        ArrayList<UserVM> arrUser = new ArrayList<UserVM>();
        String query = "";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                
                UserVM userVM = new UserVM();
                
                userVM.setUser_State_name(rs.getString(""));
                userVM.setRol_name(rs.getString(""));
                userVM.setUser_Name(rs.getString(""));
                userVM.setEmail(rs.getString(""));
                userVM.setPassword(rs.getString(""));
                userVM.setPerfil_image(rs.getString(""));
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        
        return arrUser;
    }
    
    /* Actualizar usuario*/
    public void UpdateUser(User user){
        
        String query = "call pago_de_facturacion_db.SP_U_USER(?,?,?,?,?,?)";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_user_state_id", user.getUser_State_id());
            cs.setString("p_user_name", user.getUser_Name());
            cs.setString("p_email", user.getEmail());
            cs.setString("p_password", user.getPassword());
            cs.setString("p_perfil_image", user.getPerfil_image());
            cs.setInt("p_id_user", user.getId_User());
            
            cs.executeUpdate();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
    }
    
    /* Borrado logico*/
    public void DeleteUser(User user){
        
        String query = "call pago_de_facturacion_db.SP_D_USER(?,?,?,?,?,?)";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_id_user", user.getId_User());
            
            cs.executeUpdate();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        
    }

}
