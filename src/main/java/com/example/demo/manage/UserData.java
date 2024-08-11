package com.example.demo.manage;

import com.example.demo.User;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Repository
public interface UserData extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}