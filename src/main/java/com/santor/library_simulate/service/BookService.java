package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Book;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();
    void addBook(Book book);

}
