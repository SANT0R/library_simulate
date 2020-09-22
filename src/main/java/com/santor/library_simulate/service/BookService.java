package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.model.Book;

import java.util.List;

public interface BookService {

    /**
     * Get all books
     * @param atStock -
     * @return List<BookDTO>
     */
    List<BookDTO> getAll(Boolean atStock);

    /**
     * Get a book by id
     * @param id -
     * @return BookDTO
     */
    BookDTO getById(Long id);

    /**
     * Get a book by full name
     * @param fullName -
     * @return List<BookDTO>
     */
    List<BookDTO> getByName(String fullName);

    /**
     * Delete all books
     */
    void deleteAll();

    /**
     * Delete a book by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a book by name
     * @param fullName -
     */
    void deleteByName(String fullName);

    /**
     * Update a book
     * @param book -
     */
    void update(Book book);

    /**
     * Add a book
     * @param book -
     */
    void add(Book book);

}
