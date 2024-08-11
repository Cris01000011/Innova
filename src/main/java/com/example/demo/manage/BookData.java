package com.example.demo.manage;

import com.example.demo.object.BookObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookData extends MongoRepository<BookObject, String> {
}