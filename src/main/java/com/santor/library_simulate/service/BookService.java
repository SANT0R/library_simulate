package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface BookService {
    List<BookDTO> findByName(String fullName);
    List<BookDTO> getAll();
    List<BookDTO> getAllById(List ids);
    BookDTO getById(Long id);
    void deleteAllById(List ids);
    void deleteAll();
    void deleteById(Book book);
    void deleteByName(String fullName);
    void update(Book book);
    void add(Book book);


}
