package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.AuthorRepository;
import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.mapper.AuthorMapper;
import com.santor.library_simulate.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;


    @Override
    public List<AuthorDTO> getAll() {


        return authorMapper.toDTOList(authorRepository.findAll());
    }



    @Override
    public AuthorDTO getById(Long id) {


        return authorMapper.toDTO (authorRepository.getOne(id));
    }

    @Override
    public AuthorDTO getByName(String fullName) {

        return authorMapper.toDTO (authorRepository.findByFullName(fullName));
    }

    @Override
    public void deleteByName(String fullName) {


        authorRepository.delete(authorRepository.findByFullName(fullName));

    }

    @Override
    public void add(Author author) {

        authorRepository.save(author);

    }

    @Override
    public void deleteAll() {

        authorRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        authorRepository.deleteById(id);

    }

    @Override
    public void update(Author author) {

        authorRepository.save(author);

    }


}