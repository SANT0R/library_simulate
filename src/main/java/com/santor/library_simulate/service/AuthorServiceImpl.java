package com.santor.library_simulate.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Rent;
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

    public List<AuthorDTO> getAll() {

        List<Author> authorList = new ArrayList<>();
        authorRepository.findAll().forEach(authorList::add);

        return authorMapper.toDTOList(authorList);
    }

    public List<AuthorDTO> getAllById(List ids) {

        List<Author> authorList = new ArrayList<>();
        authorRepository.findAllById(ids).forEach((Consumer) authorList);

        return authorMapper.toDTOList(authorList);
    }

    public void deleteAllById(List ids) {

        List<Author> authorList = new ArrayList<>();
        authorRepository.findAllById(ids).forEach((Consumer) authorList);
        authorRepository.deleteAll(authorList);

    }

    public AuthorDTO getById(Long id) {

        Optional<Author> optionalAuthor =  authorRepository.findById(id);
        Author author = optionalAuthor.get();

        return authorMapper.toDTO (author);
    }

    public void add(Author author) {

        authorRepository.save(author);

    }

    public void deleteAll() {

        authorRepository.deleteAll();

    }

    public void deleteById(Author author) {

        authorRepository.delete(author);

    }

    public void update(Author author) {

        authorRepository.save(author);

    }


}