/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Entities;

/**
 *
 * @author user
 */
public class Transacction_detail {

    public int getIdTransacction_detail() {
        return idTransacction_detail;
    }

    public void setIdTransacction_detail(int idTransacction_detail) {
        this.idTransacction_detail = idTransacction_detail;
    }

    public int getFK_Id_Factura() {
        return FK_Id_Factura;
    }

    public void setFK_Id_Factura(int FK_Id_Factura) {
        this.FK_Id_Factura = FK_Id_Factura;
    }

    public double getTotal_Pago() {
        return Total_Pago;
    }

    public void setTotal_Pago(double Total_Pago) {
        this.Total_Pago = Total_Pago;
    }

    public double getTotal_Impuestos() {
        return Total_Impuestos;
    }

    public void setTotal_Impuestos(double Total_Impuestos) {
        this.Total_Impuestos = Total_Impuestos;
    }

    public int getFK_Id_User() {
        return FK_Id_User;
    }

    public void setFK_Id_User(int FK_Id_User) {
        this.FK_Id_User = FK_Id_User;
    }
    int idTransacction_detail;
    int FK_Id_Factura;
    double Total_Pago;
    double Total_Impuestos;
    int FK_Id_User;
    
}
