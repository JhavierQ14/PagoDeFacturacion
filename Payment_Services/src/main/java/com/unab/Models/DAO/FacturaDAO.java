/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Factura_Datos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class FacturaDAO {
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public ArrayList<Factura_Datos>  BuscarF(int NIC,int TDF){
            
        ArrayList<Factura_Datos> DTF = null;
        try {
            DTF = new ArrayList<Factura_Datos>();
            CallableStatement qry = connection.prepareCall("{call pago_de_facturacion_db.PS_S_FACTURA(?,?)}");
            qry.setInt("PNIC", NIC);
            qry.setInt("PTDF", TDF);
            
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
        
                Factura_Datos dtf = new Factura_Datos();
            dtf.setIdFactura_Datos(rs.getInt("idFactura_Datos"));
            dtf.setDeuda(rs.getInt("Deuda"));
            dtf.setNIC(rs.getInt("NIC"));
            dtf.setId_Invoice(rs.getInt("Id_Invoice"));
            DTF.add(dtf);
        }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        return DTF;
}
}
