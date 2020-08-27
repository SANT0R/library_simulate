package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Author;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class AuthorServiceTest {

    private AuthorService authorService = Mockito.mock(AuthorService.class) ;

    private Author author ;

    AuthorServiceTest(Author author) {
        this.author = author;
    }


    @Test
    void add() throws Exception {


        authorService.add(author);

        Mockito.verify (authorService).add(author);

    }

    @Test
    void update() throws Exception {



        authorService.update(author);

        Mockito.verify (authorService).update(author);

    }

    @Test
    void deleteById() throws Exception {



        authorService.deleteById(author.getId());

        Mockito.verify (authorService).deleteById(author.getId());

    }

    @Test
    void deleteAll() throws Exception {



        authorService.deleteAll();

        Mockito.verify (authorService).deleteAll();

    }


    @Test
    void deleteByName() throws Exception {



        authorService.deleteByName(author.getFullName());

        Mockito.verify (authorService).deleteByName(author.getFullName());

    }


    @Test
    void getByName() throws Exception {



        authorService.getByName(author.getFullName());

        Mockito.verify (authorService).getByName(author.getFullName());

    }


    @Test
    void getById() throws Exception {



        authorService.getById(author.getId());

        Mockito.verify (authorService).getById(author.getId());

    }


    @Test
    void deleteAllById() throws Exception {


        List authors = null;
        authors.add(author.getId()) ;

        authorService.deleteAllById(authors);

        Mockito.verify (authorService).deleteAllById(authors);

    }


    @Test
    void getAllById() throws Exception {


        List authors = null;
        authors.add(author.getId()) ;


        authorService.getAllById(authors);

        Mockito.verify (authorService).getAllById(authors);

    }


    @Test
    void getAll() throws Exception {



        authorService.getAll();

        Mockito.verify (authorService).getAll();

    }



}