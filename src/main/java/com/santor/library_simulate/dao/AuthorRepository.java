package com.santor.library_simulate.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santor.library_simulate.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}