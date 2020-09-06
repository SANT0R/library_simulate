package com.santor.library_simulate.mapper;

import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class ClientMapperTest {

    private AuthorService authorService = Mockito.mock(AuthorService.class) ;
    private Author author = Mockito.mock(Author.class) ;




    @Test
    void add(){


        authorService.add(author);

        Mockito.verify (authorService).add(author);

    }

    @Test
    void update(){



        authorService.update(author);

        Mockito.verify (authorService).update(author);

    }

    @Test
    void deleteById(){



        authorService.deleteById(author.getId());

        Mockito.verify (authorService).deleteById(author.getId());

    }

    @Test
    void deleteAll(){



        authorService.deleteAll();

        Mockito.verify (authorService).deleteAll();

    }


    @Test
    void deleteByName(){



        authorService.deleteByName(author.getFullName());

        Mockito.verify (authorService).deleteByName(author.getFullName());

    }


    @Test
    void getByName(){



        authorService.getByName(author.getFullName());

        Mockito.verify (authorService).getByName(author.getFullName());

    }


    @Test
    void getById() {



        authorService.getById(author.getId());

        Mockito.verify (authorService).getById(author.getId());

    }



    @Test
    void getAll() {



        authorService.getAll();

        Mockito.verify (authorService).getAll();

    }



}