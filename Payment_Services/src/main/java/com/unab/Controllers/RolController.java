package com.unab.Controllers;

import com.unab.Models.DAO.*;
import com.unab.Entities.*;

import java.util.*;

public class RolController {

    RolDAO rDAO = new RolDAO();
    
    public ArrayList<Rol> ReadRol(){ return rDAO.ReadRol(); }
    
}
