package com.example.demo.manage;

import java.util.List;
import java.time.LocalDate;

import com.example.demo.object.LoginObject;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginManage {
    @Autowired
    private LoginData loginData;

    public List<LoginObject> getAllLoans() {
        return loginData.findAll();
    }

    public LoginObject createLoan(LoginObject loginObject) {
        loginObject.setDate(LocalDate.now());
        loginObject.setFlag(false);
        return loginData.save(loginObject);
    }

    public void returnLoan(String id) {
        LoginObject loginObject = loginData.findById(id).orElse(null);
        if (loginObject != null) {
            loginObject.setFlag(true);
            loginObject.setReturn(LocalDate.now());
            loginData.save(loginObject);
        }
    }

    public void deleteLoan(String id) {
        loginData.deleteById(id);
    }
}
