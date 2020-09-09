package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookServiceTest {

    private BookService entityService = Mockito.mock(BookService.class) ;
    private Book entity = Mockito.mock(Book.class) ;



    @Test
    void add(){


        entityService.add(entity);

        Mockito.verify (entityService).add(entity);

    }

    @Test
    void update(){



        entityService.update(entity);

        Mockito.verify (entityService).update(entity);

    }

    @Test
    void deleteById(){



        entityService.deleteById(entity.getId());

        Mockito.verify (entityService).deleteById(entity.getId());

    }

    @Test
    void deleteAll(){



        entityService.deleteAll();

        Mockito.verify (entityService).deleteAll();

    }


    @Test
    void deleteByName(){



        entityService.deleteByName(entity.getFullName());

        Mockito.verify (entityService).deleteByName(entity.getFullName());

    }


    @Test
    void getByName(){



        entityService.getByName(entity.getFullName());

        Mockito.verify (entityService).getByName(entity.getFullName());

    }


    @Test
    void getById(){



        entityService.getById(entity.getId());

        Mockito.verify (entityService).getById(entity.getId());

    }



    @Test
    void getAll(){



        entityService.getAll(Boolean.TRUE);

        Mockito.verify (entityService).getAll(Boolean.TRUE);

    }



}