package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;

import java.util.List;

public interface AuthorService {

    /**
     * Get all authors
     * @return List<AuthorDTO>
     */
    List<AuthorDTO> getAll();

    /**
     * Get a author by id
     * @param id
     * @return AuthorDTO
     */
    AuthorDTO getById(Long id);

    /**
     * Get a author by full name
     * @param fullName
     * @return List<AuthorDTO>
     */List<AuthorDTO> getByName(String fullName);

    /**
     * Delete all authors
     */
    void deleteAll();

    /**
     * Delete a author by id
     * @param id
     */
    void deleteById(Long id);

    /**
     * Delete a author by name
     * @param fullName
     */
    void deleteByName(String fullName);

    /**
     * Update a author
     * @param author
     */
    void update(Author author);

    /**
     * Add a author
     * @param author
     */
    void add(Author author);

}
