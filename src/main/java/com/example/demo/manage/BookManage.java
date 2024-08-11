package com.example.demo.manage;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.object.BookObject;

@Service
public class BookManage {
    @Autowired
    private BookData books;

    public List<BookObject> getAllBooks() {
        return books.findAll();
    }

    public BookObject getBookById(String id) {
        return books.findById(id).orElse(null);
    }

    public BookObject insertBook(BookObject booke) {
        return books.save(booke);
    }

    public void deleteBook(String id) {
        books.deleteById(id);
    }
}