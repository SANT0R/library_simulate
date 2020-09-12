package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.AuthorRepository;
import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.AuthorMapper;
import com.santor.library_simulate.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    private AuthorRepository entityRepository;
    private AuthorMapper entityMapper;


    @Override
    public void add(Author author) {

        entityRepository.save(author);

    }

    @Override
    public void update(Author author) {

        Author entity = entityRepository.getOne(author.getId());
        if (entity.getId() != null) {

            entityRepository.save(author);

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<AuthorDTO> getAll() {


        return entityMapper.toDTOList(entityRepository.findAll());
    }



    @Override
    public AuthorDTO getById(Long id) {

        Author entity = entityRepository.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<AuthorDTO> getByName(String fullName) {

        List<Author> authors = entityRepository.findByFullNameContains(fullName);

        return entityMapper.toDTOList (authors);

    }

    @Override
    public void deleteByName(String fullName) {

        Author entity = entityRepository.findByFullName(fullName);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        Author entity = entityRepository.getOne(id);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }


}