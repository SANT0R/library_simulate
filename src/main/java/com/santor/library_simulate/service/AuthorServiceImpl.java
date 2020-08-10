package com.santor.library_simulate.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.dao.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {

        List<Author> AuthorList = new ArrayList<>();
        authorRepository.findAll().forEach(AuthorList::add);
        return AuthorList;
    }

    public Author addAuthor(Author author) {

        author = authorRepository.save(author);

        return author;
    }

}