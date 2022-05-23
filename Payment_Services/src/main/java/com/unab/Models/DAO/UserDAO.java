package com.unab.Models.DAO;

import com.unab.DB.*;
import com.unab.Entities.*;
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
            qry.setString("PUsername", user.getUser_name());
            qry.setString("PEmail", user.getEmail());
            qry.setString("Ppass", user.getPassword());

            ResultSet rs = qry.executeQuery();
            if (rs.next()) {

                confirmation = 1;
                return confirmation;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());

        }

        return confirmation;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
 /*Obtener datos del usuario*/
    public ArrayList<UserOnLineVM> UserOnLine(String userName, String email) {

        ArrayList<UserOnLineVM> data = null;
        String query = "call pago_de_facturacion_db.SP_ONLINE_USER(?,?)";

        try {

            data = new ArrayList<UserOnLineVM>();
            CallableStatement cs = connection.prepareCall(query);
            cs.setString("PUsername", userName);
            cs.setString("PEmail", email);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                UserOnLineVM userLine = new UserOnLineVM();
                userLine.setId_user(rs.getInt("id_user"));
                userLine.setUser_name(rs.getString("user_name"));
                userLine.setEmail(rs.getString("email"));
                userLine.setId_employee(rs.getInt("id_employee"));
                userLine.setEmployee_name(rs.getString("employee_name"));
                userLine.setEmployee_lastname(rs.getString("employee_lastname"));
                data.add(userLine);
            }

            connection.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }

        return data;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
 /*Crear Usuario*/
    public void CreateUser(User user) {

        String query = "{call pago_de_facturacion_db.SP_C_USER(?,?,?,?,?)}";

        try {

            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_rol_id", user.getRol_id());
            cs.setInt("p_user_state_id", user.getUser_state_id());
            cs.setString("p_user_name", user.getUser_name());
            cs.setString("p_email", user.getEmail());
            cs.setString("p_password", user.getPassword());
            cs.setString("p_perfil_image", user.getPerfil_image());

            cs.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());

        }
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
 /* Mostrar usuario*/
    public ArrayList<UserVM> ReadUser() {

        ArrayList<UserVM> arrUser = new ArrayList<UserVM>();
        String query = "call pago_de_facturacion_db.SP_R_USER()";

        try {

            CallableStatement cs = connection.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                UserVM userVM = new UserVM();
            
                userVM.setUser_name(rs.getString("user_name"));
                userVM.setEmail(rs.getString("email"));
                userVM.setPassword(rs.getString("password"));
                userVM.setPerfil_image(rs.getString("perfil_image"));
                userVM.setUser_state_name(rs.getString("user_state_name"));
                userVM.setRol_name(rs.getString("rol_name"));
                arrUser.add(userVM);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());

        }

        return arrUser;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
 /* Actualizar usuario*/
    public void UpdateUser(User user) {

        String query = "call pago_de_facturacion_db.SP_U_USER(?,?,?,?,?,?)";

        try {

            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_rol_id", user.getRol_id());
            cs.setInt("p_user_state_id", user.getUser_state_id());
            cs.setString("p_user_name", user.getUser_name());
            cs.setString("p_email", user.getEmail());
            cs.setString("p_password", user.getPassword());
            cs.setString("p_perfil_image", user.getPerfil_image());
            cs.setInt("p_id_user", user.getId_user());

            cs.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());

        }
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
 /* Borrado logico*/
    public void DeleteUser(User user) {

        String query = "call pago_de_facturacion_db.SP_D_USER(?)";

        try {

            CallableStatement cs = connection.prepareCall(query);
            cs.setInt("p_id_user", user.getId_user());

            cs.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error " + e.toString());

        }

    }

}
