package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author addAuthor(Author author);

}
