package com.santor.library_simulate.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Author;
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

    @Override
    public List<BookDTO> getAll() {

        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);

        return bookMapper.toDTOList(bookList);
    }

    @Override
    public List<BookDTO> getAllById(List ids) {

        List<Book> bookList = new ArrayList<>();
        bookRepository.findAllById(ids).forEach((Consumer) bookList);

        return bookMapper.toDTOList(bookList);
    }

    @Override
    public void deleteAllById(List ids) {

        List<Book> bookList = new ArrayList<>();
        bookRepository.findAllById(ids).forEach((Consumer) bookList);
        bookRepository.deleteAll(bookList);

    }

    @Override
    public BookDTO getById(Long id) {

        Optional<Book> optionalBook =  bookRepository.findById(id);
        Book book = optionalBook.get();

        return bookMapper.toDTO (book);
    }

    @Override
    public List<BookDTO> findByName(String fullName) {
        List<Book> bookList = bookRepository.findByFullName(fullName);

        return bookMapper.toDTOList (bookList);
    }

    @Override
    public void deleteByName(String fullName) {
        List<Book> bookList = bookRepository.findByFullName(fullName);
        bookRepository.deleteAll(bookList);
    }

    @Override
    public void add(Book book) {

        bookRepository.save(book);

    }

    @Override
    public void deleteAll() {

        bookRepository.deleteAll();

    }

    @Override
    public void deleteById(Book book) {

        bookRepository.delete(book);

    }

    @Override
    public void update(Book book) {

        bookRepository.save(book);

    }


}