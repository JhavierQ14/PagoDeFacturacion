/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Transaccion {

    public int getTransaction_type_id() {
        return transaction_type_id;
    }

    public void setTransaction_type_id(int transaction_type_id) {
        this.transaction_type_id = transaction_type_id;
    }

    public int getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(int payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTransaction_cod() {
        return transaction_cod;
    }

    public void setTransaction_cod(int transaction_cod) {
        this.transaction_cod = transaction_cod;
    }

    public Date getTransaciton_date() {
        return transaciton_date;
    }

    public void setTransaciton_date(Date transaciton_date) {
        this.transaciton_date = transaciton_date;
    }

    public double getAmount_transaction() {
        return amount_transaction;
    }

    public void setAmount_transaction(double amount_transaction) {
        this.amount_transaction = amount_transaction;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    int  idTransaccion;
    int transaction_type_id;
    int payment_method_id;
    int user_id;
    int transaction_cod;
    Date transaciton_date;
    double amount_transaction;
}
