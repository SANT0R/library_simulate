package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAll();
    List<AuthorDTO> getAllById(List ids);
    AuthorDTO getById(Long id);
    void deleteAllById(List ids);
    void deleteAll();
    void deleteById(Author author);
    void update(Author author);
    void add(Author author);

}
