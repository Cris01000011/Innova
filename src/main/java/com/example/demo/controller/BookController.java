package com.example.demo.controller;

import java.util.List;

import com.example.demo.manage.BookManage;
import com.example.demo.object.BookObject;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookManage book;

    @GetMapping
    public List<BookObject> getAllBooks() {
        return book.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookObject getBookById(@PathVariable String id) {
        return book.getBookById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BookObject createBook(@RequestBody BookObject bookObject) {
        return book.insertBook(bookObject);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteBook(@PathVariable String id) {
        book.deleteBook(id);
    }
}
