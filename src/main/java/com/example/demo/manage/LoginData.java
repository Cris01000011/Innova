package com.example.demo.manage;

import com.example.demo.object.LoginObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginData extends MongoRepository<LoginObject, String> {
}