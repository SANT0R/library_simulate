package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookServiceTest {

    private BookService bookService = Mockito.mock(BookService.class) ;
    private Book book = Mockito.mock(Book.class) ;




    @Test
    void add(){


        bookService.add(book);

        Mockito.verify (bookService).add(book);

    }

    @Test
    void update(){



        bookService.update(book);

        Mockito.verify (bookService).update(book);

    }

    @Test
    void deleteById(){



        bookService.deleteById(book.getId());

        Mockito.verify (bookService).deleteById(book.getId());

    }

    @Test
    void deleteAll(){



        bookService.deleteAll();

        Mockito.verify (bookService).deleteAll();

    }


    @Test
    void deleteByName(){



        bookService.deleteByName(book.getFullName());

        Mockito.verify (bookService).deleteByName(book.getFullName());

    }


    @Test
    void getByName(){



        bookService.getByName(book.getFullName());

        Mockito.verify (bookService).getByName(book.getFullName());

    }


    @Test
    void getById(){



        bookService.getById(book.getId());

        Mockito.verify (bookService).getById(book.getId());

    }



    @Test
    void getAll(){



        bookService.getAll();

        Mockito.verify (bookService).getAll();

    }



}