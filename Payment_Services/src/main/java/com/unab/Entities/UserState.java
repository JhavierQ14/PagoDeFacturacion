package com.unab.Entities;

public class UserState {

    int id_user_state;
    String user_state_name;

    public UserState() {
        this.id_user_state = 0;
        this.user_state_name = "";
    }

    @Override
    public String toString() {
        return user_state_name;
    }

    public int getId_user_state() {
        return id_user_state;
    }

    public void setId_user_state(int id_user_state) {
        this.id_user_state = id_user_state;
    }

    public String getUser_state_name() {
        return user_state_name;
    }

    public void setUser_state_name(String user_state_name) {
        this.user_state_name = user_state_name;
    }
}
