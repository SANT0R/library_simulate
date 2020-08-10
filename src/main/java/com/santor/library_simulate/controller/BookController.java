package com.santor.library_simulate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.service.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping()
    public List<Book> getAll() {
        System.out.println("Inside Home Controller");

        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}