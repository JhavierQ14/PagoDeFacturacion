
package com.unab.Models.ViewModels;


public class UserVM {
    
    String user_name;
    String email;
    String password;
    String perfil_image;
    String user_state_name;
    String rol_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil_image() {
        return perfil_image;
    }

    public void setPerfil_image(String perfil_image) {
        this.perfil_image = perfil_image;
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
    
}
