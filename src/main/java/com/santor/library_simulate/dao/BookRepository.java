package com.santor.library_simulate.dao;



import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santor.library_simulate.model.Book;

import java.util.List;
/*
@EnableJpaRepositories

 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String fullName);




}