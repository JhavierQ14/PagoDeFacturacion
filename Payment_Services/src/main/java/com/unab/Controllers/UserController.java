package com.unab.Controllers;

import com.unab.Models.DAO.UserDAO;
import com.unab.Entities.User;
import com.unab.Models.ViewModels.*;

import java.util.*;

public class UserController {
    
    UserDAO uDAO = new UserDAO();
    
    public int LogIn(User user){ return uDAO.LogIn(user); }
    
    public ArrayList<UserOnLineVM> UserOnLine(String u) {
        
        return uDAO.UserOnLine(u);
    }
    
    public void CreateUser(User user){ uDAO.CreateUser(user); }
    
    public ArrayList<UserVM> ReadUser(){ return uDAO.ReadUser(); }
    
    public void UpdateUser(User user){ uDAO.UpdateUser(user); }
    
//    public void DeleteUser(User user){ uDAO.DeleteUser(user); }

}
