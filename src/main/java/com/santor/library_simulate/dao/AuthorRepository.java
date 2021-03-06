package com.santor.library_simulate.dao;


import com.santor.library_simulate.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByFullName(String fullName);

    List<Author> findByFullNameContains(String fullName);
}