package com.example.demo.dto;

import com.example.demo.role.Role;

public class user {
    private String id;
    private String user;
    private String pass;
    private Role roll;

    public user(String id, String user, String pass, Role roll) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.roll = roll;
    }

    public user(Object id, String user) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRoll() {
        return roll;
    }

    public void setRoll(Role roll) {
        this.roll = roll;
    }
}
