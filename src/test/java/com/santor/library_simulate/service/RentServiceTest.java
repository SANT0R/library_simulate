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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Spy
    private BookRepository entityRepository;

    @Spy
    private RentRepository rentRepository;

    @Spy
    private BookMapperImpl entityMapper;

    @Spy
    private RentMapperImpl rentMapper;

    @InjectMocks
    private RentServiceImpl rentService;


    @InjectMocks
    private BookServiceImpl bookService;




    @Test
    void addTest() {
        Book book = new Book();
        book.setId(254L);
        book.setFullName("asdfgh dfgd");
        book.setType("sadfsd");
        book.setDescription("dsfgash");
        book.setPublisher("dfghj dsdf");
        book.setReleaseYear(LocalDate.now());
        book.setPage(250);
        book.setStock(10);

        bookService.add(book);

        Rent rent = new Rent();
        rent.setId(301L);
        rent.setStartDate(LocalDate.now());
        rent.getBooks().add(book);

        rentRepository.save(rent);

        LocalDate expected1 = LocalDate.now().plusDays(250/5);
        LocalDate actual = rentService.getById(301L).getFinishDate();
        assertEquals(actual , expected1);


        Set<BookDTO> books = rentService.getById(301L).getBooks();
        int sumStock = 0;

        for (BookDTO book1 : books){
            sumStock+=book1.getStock();

        }

        int expected2 = 9;
        assertEquals(sumStock, expected2);
    }



}