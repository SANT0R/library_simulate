package com.santor.library_simulate.controller;

import java.util.List;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public List<BookDTO> getAll() {
        System.out.println("Inside Home Controller");

        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book) { return "done"; }
}