package com.example.demo.dto.auth;

public class Authentication {
    private String tkn;

    public Authentication(String tkn) {
        this.tkn = tkn;
    }

    public String getTkn() {
        return tkn;
    }

    public void setTkn(String tkn) {
        this.tkn = tkn;
    }
}
