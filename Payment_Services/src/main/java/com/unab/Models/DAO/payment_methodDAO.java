/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Tbl_metodo_pago;
import com.unab.Entities.Transaccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class payment_methodDAO {
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public ArrayList<Tbl_metodo_pago>  ListarMetodos(){
            
        ArrayList<Tbl_metodo_pago> mt = null;
        try {
            mt = new ArrayList<Tbl_metodo_pago>();
            CallableStatement qry = connection.prepareCall("{call pago_de_facturacion_db.PS_S_METODOS()}");
            
            
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
        
            Tbl_metodo_pago mtd = new Tbl_metodo_pago();
            mtd.setIdTbl_Metodo_pago(rs.getInt("id_payment_method"));
            mtd.setTipo_Pago(rs.getString("p_type_name"));
            mt.add(mtd);
        }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        return mt;
    
}
}
