
package com.unab.Models.ViewModels;


public class UserVM {

    public String getUser_State_name() {
        return User_State_name;
    }

    public void setUser_State_name(String User_State_name) {
        this.User_State_name = User_State_name;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
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
    
    String User_State_name;
    String rol_name;
    String User_Name;
    String Email;
    String Password;
    String perfil_image;
    
}
