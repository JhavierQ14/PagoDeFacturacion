/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Entities;

/**
 *
 * @author user
 */
public class Tbl_billetera_pago {

    public int getIdl_Billetera_pago() {
        return idl_Billetera_pago;
    }

    public void setIdl_Billetera_pago(int idl_Billetera_pago) {
        this.idl_Billetera_pago = idl_Billetera_pago;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    int idl_Billetera_pago;
    String correo;
    String password;
}
