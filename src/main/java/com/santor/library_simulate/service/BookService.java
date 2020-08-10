package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book addBook(Book book);

}
