package com.unab.Controllers;

import com.unab.Models.DAO.UserStateDAO;
import com.unab.Entities.UserState;

import java.util.*;

public class UserStateController {
    
    UserStateDAO usDAO = new UserStateDAO();
    
    public ArrayList<UserState> ReadUserState(){ return usDAO.ReadUserState();}
}
