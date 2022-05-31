/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Invoce_Type;
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
public class TransactionDAO {
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public ArrayList<Transaccion>  Listartransacciones(){
            
        ArrayList<Transaccion> TDTF = null;
        try {
            TDTF = new ArrayList<Transaccion>();
            CallableStatement qry = connection.prepareCall("{call pago_de_facturacion_db.PS_S_TRANSACTION()}");
            
            
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
        
            Transaccion tc = new Transaccion();
            tc.setIdTransaccion(rs.getInt("id_transaction"));
            tc.setPayment_method_id(rs.getInt("payment_method_id"));
            tc.setTransaction_cod(rs.getInt("transaction_cod"));
            tc.setTransaction_type_id(rs.getInt("transaction_type_id"));
            tc.setTransaciton_date(rs.getDate("transaction_date"));
            tc.setUser_id(rs.getInt("user_id"));
            tc.setAmount_transaction(rs.getDouble("amount_transaction"));
            TDTF.add(tc);
        }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            
        }
        return TDTF;
    }
}
