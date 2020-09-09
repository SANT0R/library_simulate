package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.BookRepository;
import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.mapper.BookMapperImpl;
import com.santor.library_simulate.mapper.RentMapperImpl;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {



    @Mock
    private BookMapperImpl bookMapper;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;




    @Test
    void getByNameTest() {
        Book book1 = new Book();
        book1.setFullName("konyalı");

        bookService.add(book1);

        Book book2 = new Book();
        book2.setFullName("urfalıyam ezelden");

        bookService.add(book2);

        Book book3 = new Book();
        book3.setFullName("ağrılı halo");

        bookService.add(book3);

        Book book4 = new Book();
        book4.setFullName("ya");

        bookService.add(book4);

        List<BookDTO> books = bookService.getByName("ya");

        List<BookDTO> expected = new ArrayList<>();
        books.add(bookMapper.toDTO(book1));
        books.add(bookMapper.toDTO(book2));
        books.add(bookMapper.toDTO(book4));


        assertEquals(books, expected);

    }



}