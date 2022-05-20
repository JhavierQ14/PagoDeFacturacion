
package com.unab.Models;

public class UserCache {
    
    private static String nameUser;

    public static String getNameUser() {
        return nameUser;
    }

    public static void setNameUser(String nameUser) {
        UserCache.nameUser = nameUser;
    }
    
}
