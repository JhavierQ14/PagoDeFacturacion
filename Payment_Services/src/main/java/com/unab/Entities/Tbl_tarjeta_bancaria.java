/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Entities;

/**
 *
 * @author user
 */
public class Tbl_tarjeta_bancaria {

    public int getIdtbl_tarjeta_bancaria() {
        return idtbl_tarjeta_bancaria;
    }

    public void setIdtbl_tarjeta_bancaria(int idtbl_tarjeta_bancaria) {
        this.idtbl_tarjeta_bancaria = idtbl_tarjeta_bancaria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumero_Tarjeta() {
        return Numero_Tarjeta;
    }

    public void setNumero_Tarjeta(int Numero_Tarjeta) {
        this.Numero_Tarjeta = Numero_Tarjeta;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
    int idtbl_tarjeta_bancaria;
    String Nombre;
    int Numero_Tarjeta;
    String fecha_vencimiento;
    String CVV;
}
