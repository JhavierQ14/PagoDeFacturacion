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

    int id_transacction_detail;
    int transaction_id;
    double quantity;
    String description;
    double unit_price;
    double iva;
    double amount;
    int I_invoice_type;

    public int getId_transacction_detail() {
        return id_transacction_detail;
    }

    public void setId_transacction_detail(int id_transacction_detail) {
        this.id_transacction_detail = id_transacction_detail;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getI_invoice_type() {
        return I_invoice_type;
    }

    public void setI_invoice_type(int I_invoice_type) {
        this.I_invoice_type = I_invoice_type;
    }
    
   
}
