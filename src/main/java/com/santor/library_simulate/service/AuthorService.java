package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;

import java.util.List;

public interface AuthorService {

    List<AuthorDTO> getAllAuthors();
    void addAuthor(Author author);

}
