package com.example.demo.manage;

import com.example.demo.dto.user;

import java.util.List;

public interface UserInterfaz {
    List<user> getAllElements();

    user getById(String id);

    user insert(user user);

    user update(user user, String id);

    void delete(String id);
}
