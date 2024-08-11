package com.example.demo.controller;

import java.util.List;

import com.example.demo.object.LoginObject;
import com.example.demo.manage.LoginManage;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginManage loginManage;

    @GetMapping
    public List<LoginObject> getAllLoans() {
        return loginManage.getAllLoans();
    }

    @PostMapping
    public LoginObject createLoan(@RequestBody LoginObject loginObject) {
        return loginManage.createLoan(loginObject);
    }

    @PostMapping("/return/{id}")
    public void returnLoan(@PathVariable String id) {
        loginManage.returnLoan(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        loginManage.deleteLoan(id);
    }
}
