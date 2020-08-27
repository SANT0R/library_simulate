package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> getAll();

    BookDTO getById(Long id);

    List<BookDTO> getByName(String fullName);

    void deleteAll();

    void deleteById(Long id);

    void deleteByName(String fullName);

    void update(Book book);

    void add(Book book);


}
