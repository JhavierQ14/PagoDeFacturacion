
package com.unab.Models.ViewModels;

public class UserOnLineVM {
    
    private int id_user;
    private String user_name;
    private String user_state_name;
    private String rol_name;
    private String employee_name;
    private String employee_lastname;

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

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

}
