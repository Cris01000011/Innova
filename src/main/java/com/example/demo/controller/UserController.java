package com.example.demo.controller;

import java.util.List;

import com.example.demo.manage.UserManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserManage users;

    @GetMapping("/")
    public ResponseEntity<List<com.example.demo.dto.user>> findAll(){
        List<com.example.demo.dto.user> list = users.getAllElements();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.demo.dto.user> findById(@PathVariable String id){
        com.example.demo.dto.user usuario = users.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<com.example.demo.dto.user> save(@RequestBody com.example.demo.dto.user user){
        com.example.demo.dto.user saved = users.insert(user);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        users.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.demo.dto.user> update(@RequestBody com.example.demo.dto.user user, @PathVariable String id){
        com.example.demo.dto.user update = users.update(user, id);
        return ResponseEntity.ok(update);
    }
}