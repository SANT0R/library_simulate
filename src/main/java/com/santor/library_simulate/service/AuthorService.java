package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAll();

    AuthorDTO getById(Long id);

    List<AuthorDTO> getByName(String fullName);

    void deleteAll();

    void deleteById(Long id);

    void deleteByName(String fullName);

    void update(Author author);

    void add(Author author);

}
