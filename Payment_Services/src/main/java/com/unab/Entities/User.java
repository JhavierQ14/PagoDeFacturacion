/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.Entities;

/**
 *
 * @author user
 */
public class User {

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getUser_State_id() {
        return User_State_id;
    }

    public void setUser_State_id(int User_State_id) {
        this.User_State_id = User_State_id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPerfil_image() {
        return perfil_image;
    }

    public void setPerfil_image(String perfil_image) {
        this.perfil_image = perfil_image;
    }
    int id_User;
    int User_State_id;
    String User_Name;
    String Email;
    String Password;
    String perfil_image;
    
}
