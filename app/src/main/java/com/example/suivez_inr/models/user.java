package com.example.suivez_inr.models;

import android.media.session.MediaSession;

import javax.xml.namespace.QName;

public class user {
    private String token;
    private String name;
    private String password;

    public user() {
    }

    public user(String token, String name, String password) {
        this.token = token;
        this.name = name;
        this.password = password;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
