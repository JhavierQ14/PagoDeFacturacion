/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Invoce_Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class TipoFDAO {
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public ArrayList<Invoce_Type>  ListarTiposFactura(){
            
        ArrayList<Invoce_Type> TDTF = null;
        try {
            TDTF = new ArrayList<Invoce_Type>();
            CallableStatement qry = connection.prepareCall("{call pago_de_facturacion_db.PS_S_TFACTURA()}");
            
            
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
        
            Invoce_Type tdtf = new Invoce_Type();
            tdtf.setId_invoice(rs.getInt("Id_invoice"));
            tdtf.setI_type_name(rs.getString("I_type_name"));
            TDTF.add(tdtf);
        }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        return TDTF;
    }
}
