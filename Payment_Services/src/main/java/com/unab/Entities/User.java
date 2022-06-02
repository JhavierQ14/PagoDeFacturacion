
package com.unab.Entities;

public class User {

    private int id_user;
    private int rol_id;
    private int user_state_id;
    private String user_name;
    private String password;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public int getUser_state_id() {
        return user_state_id;
    }

    public void setUser_state_id(int user_state_id) {
        this.user_state_id = user_state_id;
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
    
}
