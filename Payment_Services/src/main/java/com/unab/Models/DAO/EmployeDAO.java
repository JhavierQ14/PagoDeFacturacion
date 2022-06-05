/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Models.DAO;

import com.unab.DB.ConnectionDB;
import com.unab.Entities.Employee;
import com.unab.Models.ViewModels.EmployeMV;
import com.unab.Models.ViewModels.UserVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nelso
 */
public class EmployeDAO {
    
    ConnectionDB conn = new ConnectionDB();
    Connection connection = conn.getCon();
    
    public void CreateEmploye(Employee Empleado) {

        String query = "{call pago_de_facturacion_db.SP_C_employee(?,?,?,?,?,?)}";

        try {

            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_user_id", Empleado.getUser_id());
            cs.setString("p_employee_name", Empleado.getEmployee_name());
            cs.setString("p_employee_lastname", Empleado.getEmployee_Lastname());
            cs.setString("p_e_identification_document", Empleado.getE_identification_document());
            cs.setString("p_phone", Empleado.getPhone());
            cs.setString("p_email_address", Empleado.getEmail_adrdess());
            cs.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error CreateUser " + e.toString());

        }
    }


     public ArrayList<EmployeMV> ReadEmploye() {

        ArrayList<EmployeMV> arrUser = new ArrayList<EmployeMV>();
        String query = "call pago_de_facturacion_db.sp_r_employe";

        try {

            CallableStatement cs = connection.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                EmployeMV employemv = new EmployeMV();
                
                employemv.setUser_id(rs.getInt("user_id"));
                employemv.setEmployee_name(rs.getString("employee_name"));
                employemv.setEmployee_Lastname(rs.getString("employee_lastname"));
                employemv.setE_identification_document(rs.getString("e_identification_document"));
                employemv.setPhone(rs.getString("phone"));
                employemv.setEmail_adrdess(rs.getString("email_address"));
                employemv.setUser_name(rs.getString("user_name"));
                arrUser.add(employemv);
                
                
               
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error ReadUser " + e.toString());

        }

        return arrUser;
    }
}
