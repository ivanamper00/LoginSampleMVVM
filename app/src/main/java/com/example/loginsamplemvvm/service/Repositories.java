package com.example.loginsamplemvvm.service;

import com.example.loginsamplemvvm.model.LoginModel;

public class Repositories {
    private static Repositories instance;

    public static Repositories getInstance(){
        if(instance == null){
            instance = new Repositories();
        }
        return instance;
    }


    public LoginModel getUser(){
        //retrofit
        return new LoginModel("brix", "pomoy");
    }


}
