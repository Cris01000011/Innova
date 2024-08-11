package com.example.demo.controller;

import com.example.demo.dto.auth.NewUserAuth;
import com.example.demo.dto.auth.LoginAuth;
import com.example.demo.manage.AuthManage;
import com.example.demo.dto.auth.Authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthManage auts;
    @PostMapping(value = "/login")
    public ResponseEntity<Authentication> login(@RequestBody LoginAuth loginuser) {
        Authentication Authentication = auts.login(loginuser);
        return ResponseEntity.ok(Authentication);
    }
    @PostMapping("/register")
    public ResponseEntity<Authentication> register(@RequestBody NewUserAuth NewUserAuth) {
        Authentication Authentication = auts.register(NewUserAuth);
        return ResponseEntity.ok(Authentication);
    }
}
