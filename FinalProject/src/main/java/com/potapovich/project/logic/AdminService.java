package com.potapovich.project.logic;

public class AdminService {

    public boolean checkAdminLoginPassword(String login, String password){


        return login.equals("admin") && password.equals("admin");
    }




}
