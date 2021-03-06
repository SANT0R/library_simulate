package com.santor.library_simulate.dao;


import com.santor.library_simulate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByFullName(String fullName);

    List<Book> findByFullNameContains(String fullName);



}