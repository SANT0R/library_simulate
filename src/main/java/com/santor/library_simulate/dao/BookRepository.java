package com.santor.library_simulate.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santor.library_simulate.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    
}