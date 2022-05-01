/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Entities;

/**
 *
 * @author user
 */
public class Tbl_metodo_pago {

    public int getIdTbl_Metodo_pago() {
        return idTbl_Metodo_pago;
    }

    public void setIdTbl_Metodo_pago(int idTbl_Metodo_pago) {
        this.idTbl_Metodo_pago = idTbl_Metodo_pago;
    }

    public String getTipo_Pago() {
        return Tipo_Pago;
    }

    public void setTipo_Pago(String Tipo_Pago) {
        this.Tipo_Pago = Tipo_Pago;
    }
    int idTbl_Metodo_pago;
    String Tipo_Pago;
}
