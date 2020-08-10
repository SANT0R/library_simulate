package com.santor.library_simulate.service;


import java.util.ArrayList;
import java.util.List;

import com.santor.library_simulate.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.dao.BookRepository;
import com.santor.library_simulate.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    private BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {

        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);

        return bookMapper.toDTOList(bookList);
    }

    public void addBook(Book book) {

        book = bookRepository.save(book);

    }

}