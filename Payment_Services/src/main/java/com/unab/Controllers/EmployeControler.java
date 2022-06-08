package com.unab.Controllers;

import com.unab.Entities.Employee;
import com.unab.Models.DAO.EmployeDAO;
import com.unab.Models.ViewModels.EmployeMV;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nelso
 */
public class EmployeControler {

    EmployeDAO employeDAO = new EmployeDAO();

    public ArrayList<EmployeMV> ReadEmploye() {
        return employeDAO.ReadEmploye();
    }

    public void CreateEmploye(Employee employe) {
        employeDAO.CreateEmploye(employe);
    }

    public void UpdateEmployee(Employee employe) {
        employeDAO.UpdateEmploye(employe);
    }
//    
//    public void DeleteUser(User user){ uDAO.DeleteUser(user); }
//
//    
}
