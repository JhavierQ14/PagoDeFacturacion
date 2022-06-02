/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Transaccion;
import com.unab.Entities.Transacction_detail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class Transaction_DetailDAO {
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public void InsertarTransaccionD(Transacction_detail td){
    try {
            CallableStatement cb = connection.prepareCall("{call PS_I_TRANSACTIOND(?,?,?,?,?,?,?)}");
            cb.setInt("PTID", td.getTransaction_id());
            cb.setDouble("PQUANT", td.getQuantity());
            cb.setString("PDesc", td.getDescription());
            cb.setDouble("PUnit_p", td.getUnit_price());
            cb.setDouble("PIva", td.getIva());
            cb.setDouble("PAmount", td.getAmount());
            cb.setInt("PInvoice", td.getI_invoice_type());
            
            cb.execute();
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex,"Mensje sistems",1);
            
        }}
}
