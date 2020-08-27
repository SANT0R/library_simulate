package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class BookServiceTest {

    private BookService bookService = Mockito.mock(BookService.class) ;

    private  Book book ;



    @Test
    void add() throws Exception {


        bookService.add(book);

        Mockito.verify (bookService).add(book);

    }

    @Test
    void update() throws Exception {



        bookService.update(book);

        Mockito.verify (bookService).update(book);

    }

    @Test
    void deleteById() throws Exception {



        bookService.deleteById(book.getId());

        Mockito.verify (bookService).deleteById(book.getId());

    }

    @Test
    void deleteAll() throws Exception {



        bookService.deleteAll();

        Mockito.verify (bookService).deleteAll();

    }


    @Test
    void deleteByName() throws Exception {



        bookService.deleteByName(book.getFullName());

        Mockito.verify (bookService).deleteByName(book.getFullName());

    }


    @Test
    void getByName() throws Exception {



        bookService.getByName(book.getFullName());

        Mockito.verify (bookService).getByName(book.getFullName());

    }


    @Test
    void getById() throws Exception {



        bookService.getById(book.getId());

        Mockito.verify (bookService).getById(book.getId());

    }


    @Test
    void deleteAllById() throws Exception {


        List books = null;
        books.add(book.getId()) ;

        bookService.deleteAllById(books);

        Mockito.verify (bookService).deleteAllById(books);

    }


    @Test
    void getAllById() throws Exception {


        List books = null;
        books.add(book.getId()) ;


        bookService.getAllById(books);

        Mockito.verify (bookService).getAllById(books);

    }


    @Test
    void getAll() throws Exception {



        bookService.getAll();

        Mockito.verify (bookService).getAll();

    }



}