package com.santor.library_simulate.service;



import java.util.ArrayList;
import java.util.List;

import com.santor.library_simulate.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.dao.AuthorRepository;
import com.santor.library_simulate.mapper.AuthorMapper;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAllAuthors() {

        List<Author> authorList = new ArrayList<>();
        authorRepository.findAll().forEach(authorList::add);

        return authorMapper.toDTOList(authorList);
    }

    public void addAuthor(Author author) {

        author = authorRepository.save(author);


    }

}