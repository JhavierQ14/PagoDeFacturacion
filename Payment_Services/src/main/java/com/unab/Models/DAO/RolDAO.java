package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.*;

import java.util.*;
import java.sql.*;
import javax.swing.*;

public class RolDAO {
    
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public ArrayList<Rol> ReadRol(){
        
        ArrayList<Rol> listRol = new ArrayList<Rol>();
        String query = "select * from pago_de_facturacion_db.rol";
        
        try {
            
            CallableStatement cs = connection.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {                
                
                Rol rol = new Rol();
                rol.setId_rol(rs.getInt("id_rol"));
                rol.setRol_name(rs.getString("rol_name"));
                listRol.add(rol);
            }
            
            connection.close();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null ,"Error " + e.toString());
        }
        
        return listRol;
    }
}
