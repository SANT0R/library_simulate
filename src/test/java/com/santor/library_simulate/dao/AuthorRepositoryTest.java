package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository ;

    private void addAuthor(Long id,String fullName){

        Author author = new Author();
        author.setId(id);
        author.setFullName(fullName);

        authorRepository.save(author);
    }


    @Test
    void addTest(){

        authorRepository.deleteAll();

        addAuthor(20L,"Mehmet Santor");


        Author expected = authorRepository.getOne(20L);
        assertEquals(expected.getId(), 20L);

    }


    @Test
    void deleteByIdTest(){

        authorRepository.deleteAll();

        addAuthor(10L,"Mehmet Santor");


        authorRepository.deleteById(10L);

        assertEquals(authorRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        authorRepository.deleteAll();

        addAuthor(20L,"Mehmet Santor");


        assertEquals(authorRepository.count(),1);
        authorRepository.deleteAll();


        assertEquals(authorRepository.count(), 0);

    }


    @Test
    void deleteByNameTest(){

        authorRepository.deleteAll();

        addAuthor(20L,"Mehmet Santor");



        assertEquals(authorRepository.count(),1);

        authorRepository.delete(authorRepository.findByFullName("Mehmet Santor"));


        assertEquals(authorRepository.count(),0);


    }


    @Test
    void getByNameTest(){

        authorRepository.deleteAll();

        addAuthor(20L,"Mehmet Santor");

        Author  author1 = authorRepository.findByFullName("Mehmet Santor");

        assertEquals(author1.getFullName(),"Mehmet Santor" );

    }


    @Test
    void getByIdTest() {

        authorRepository.deleteAll();

        addAuthor(20L,"Mehmet Santor");
        Author author1 = authorRepository.getOne(20L);

        assertEquals(author1.getId(), 20L);

    }



    @Test
    void getAllTest() {

        authorRepository.deleteAll();

        addAuthor(20L,"Mehmet Santor");

        addAuthor(30L,"asghdf sadfg");

        addAuthor(40L,"fgd dfghr");


        assertEquals(authorRepository.count(), 3);

        Author author1 = authorRepository.getOne(20L);

        assertEquals(author1.getId(), 20L);

        Author author2 = authorRepository.getOne(30L);

        assertEquals(author2.getId(), 30L);

        Author author3 = authorRepository.getOne(40L);

        assertEquals(author3.getId(), 40L);
    }



}
