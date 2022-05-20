
package com.unab.Models.ViewModels;

public class UserOnLineVM {
    
    private int id_User;
    private String User_Name;
    private String Email;
    private int idEmployee;
    private String Employee_name;
    private String Employee_Lastname;

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
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

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String Employee_name) {
        this.Employee_name = Employee_name;
    }

    public String getEmployee_Lastname() {
        return Employee_Lastname;
    }

    public void setEmployee_Lastname(String Employee_Lastname) {
        this.Employee_Lastname = Employee_Lastname;
    }
}
