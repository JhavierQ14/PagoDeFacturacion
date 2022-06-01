package com.unab.Models.ViewModels;

public class UserVM {

    int id_user;
    String user_name;
    String password;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_state_name() {
        return user_state_name;
    }

    public void setUser_state_name(String user_state_name) {
        this.user_state_name = user_state_name;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }
    String user_state_name;
    String rol_name;

}
