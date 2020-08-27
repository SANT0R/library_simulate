package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> getAll();
    List<BookDTO> getAllById(Iterable ids);
    BookDTO getById(Long id);
    List<BookDTO> getByName(String fullName);
    void deleteAllById(Iterable ids);
    void deleteAll();
    void deleteById(Book book);
    void deleteByName(String fullName);
    void update(Book book);
    void add(Book book);


}
