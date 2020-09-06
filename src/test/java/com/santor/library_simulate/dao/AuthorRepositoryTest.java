package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository ;

    private void addAuthor(Long id,String fullName){
        Rent rent = new Rent();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());

        Book book = new Book();
        book.setFullName("Facebook");
        book.setPage(800);

        Author author = new Author();
        author.setId(2L);
        author.setFullName("Mehmet Santor");
        author.getBooks().add(book);

        Client client = new Client();
        client.setEMail("alskdmlaks@gmail.com");
        client.setFullName("msantor");
        client.setPassword("1234");
        client.setPhone("30203320");

        rent.setClient(client);
        rent.getBooks().add(book);

        client.getRents().add(rent);

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
