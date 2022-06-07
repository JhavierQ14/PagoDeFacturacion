/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Tbl_tarjeta_bancaria;
import com.unab.Views.FrmBankCard;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro
 */
public class TarjetDao {
      ConnectionDB conn = new ConnectionDB();
      Connection connection = conn.getCon();
    
      public ArrayList<Tbl_tarjeta_bancaria>  TarjetaBanc(Tbl_tarjeta_bancaria tj){
            
          ArrayList<Tbl_tarjeta_bancaria> TDTF = null;
        try {
            TDTF = new ArrayList<Tbl_tarjeta_bancaria>();
            CallableStatement qry = connection.prepareCall("{call PS_TARJETABANK(?,?,?,?)}");
            qry.setString("Nombre1", tj.getNombre());
            qry.setString("Numero_Tarjeta1",tj.getNumero_Tarjeta());
            qry.setDate("fecha_vencimineto1",tj.getFecha_vencimiento());
            qry.setInt("CVV1", tj.getCVV());
            
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
        
            Tbl_tarjeta_bancaria tc = new Tbl_tarjeta_bancaria();
            tc.setNombre(rs.getString("Nombre"));
            tc.setNumero_Tarjeta(rs.getString("Numero_Tarjeta"));
            tc.setFecha_vencimiento(rs.getDate("fecha_vencimineto"));
            tc.setCVV(rs.getInt("CVV"));
          
            TDTF.add(tc);
        }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        return TDTF;
    }
    
//    public void Tarjetas(Tbl_tarjeta_bancaria Tarjeta){
//         ConnectionDB conn = new ConnectionDB();
//         Connection connection1 = conn.getCon();
//
//          CallableStatement cb;
//        try {
//            cb = connection1.prepareCall("{call VerificacionPago(?,?,?,?)}");
//            cb.setString("Nombre1", Tarjeta.getNombre());
//            cb.setInt("Numero_Tarjet1", Tarjeta.getNumero_Tarjeta());
//            cb.setString("fecha_vencimiento1", Tarjeta.getFecha_vencimiento());
//            cb.setString("CVV1",Tarjeta.getCVV());
//            cb.registerOutParameter(5, java.sql.Types.VARCHAR);
//
//            cb.execute();
//            
//           JOptionPane.showMessageDialog(null,"Pago Realizado");
//        
//        } catch (SQLException ex) {
//            Logger.getLogger(FrmBankCard.class.getName()).log(Level.SEVERE, null, ex);
//        }

}
    
