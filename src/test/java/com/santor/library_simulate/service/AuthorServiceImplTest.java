package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceImplTest {

    private AuthorServiceImpl authorServiceImpl = Mockito.mock(AuthorServiceImpl.class) ;

     private Author author ;
    @Test
    void add() throws Exception {



        authorServiceImpl.add(author);

        Mockito.verify (authorServiceImpl).add(author);

    }

    @Test
    void update() throws Exception {



        authorServiceImpl.update(author);

        Mockito.verify (authorServiceImpl).update(author);

    }

    @Test
    void deleteById() throws Exception {



        authorServiceImpl.deleteById(author.getId());

        Mockito.verify (authorServiceImpl).deleteById(author.getId());

    }

    @Test
    void deleteAll() throws Exception {



        authorServiceImpl.deleteAll();

        Mockito.verify (authorServiceImpl).deleteAll();

    }


    @Test
    void deleteByName() throws Exception {



        authorServiceImpl.deleteByName(author.getFullName());

        Mockito.verify (authorServiceImpl).deleteByName(author.getFullName());

    }


    @Test
    void getByName() throws Exception {



        authorServiceImpl.getByName(author.getFullName());

        Mockito.verify (authorServiceImpl).getByName(author.getFullName());

    }


    @Test
    void getById() throws Exception {



        authorServiceImpl.getById(author.getId());

        Mockito.verify (authorServiceImpl).getById(author.getId());

    }


    @Test
    void deleteAllById() throws Exception {


        List authors = null;
        authors.add(author.getId()) ;

        authorServiceImpl.deleteAllById(authors);

        Mockito.verify (authorServiceImpl).deleteAllById(authors);

    }


    @Test
    void getAllById() throws Exception {


        List authors = null;
        authors.add(author.getId()) ;


        authorServiceImpl.getAllById(authors);

        Mockito.verify (authorServiceImpl).getAllById(authors);

    }


    @Test
    void getAll() throws Exception {



        authorServiceImpl.getAll();

        Mockito.verify (authorServiceImpl).getAll();

    }



}