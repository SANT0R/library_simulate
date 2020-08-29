package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.BookRepository;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.mapper.BookMapper;
import com.santor.library_simulate.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getAll() {

        return bookMapper.toDTOList(bookRepository.findAll());
    }


    @Override
    public BookDTO getById(Long id) {


        return bookMapper.toDTO (bookRepository.getOne(id));
    }

    @Override
    public List<BookDTO> getByName(String fullName) {


        return bookMapper.toDTOList (bookRepository.findByFullName(fullName));
    }

    @Override
    public void deleteByName(String fullName) {


        bookRepository.deleteAll(bookRepository.findByFullName(fullName));
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
    public void deleteById(Long id) {

        bookRepository.deleteById(id);

    }

    @Override
    public void update(Book book) {

        bookRepository.save(book);

    }


}