/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDB {
     private static Connection Con=null;
    public Connection getCon(){
        try {
            String url="jdbc:mysql://localhost:3306/pago_de_facturacion_db";
            String user="root"; 
            String password = "root";
            
            Con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error"+e.toString());
        }
        return Con;
    }
}
