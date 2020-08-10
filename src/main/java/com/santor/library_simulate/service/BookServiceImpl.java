package com.santor.library_simulate.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.dao.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {

        List<Book> BookList = new ArrayList<>();
        bookRepository.findAll().forEach(BookList::add);
        return BookList;
    }

    public Book addBook(Book book) {

        book = bookRepository.save(book);

        return book;
    }

}