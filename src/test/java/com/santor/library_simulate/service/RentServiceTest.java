package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.dto.RentDTO;
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
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Mock
    private RentRepository rentRepository;

    @Spy
    private RentMapperImpl rentMapper;

    @InjectMocks
    private RentServiceImpl rentService;






    @Test
    void addTest() {


        final Book book = new Book();
        book.setReleaseYear(LocalDate.now());
        book.setId(25L);
        book.setPage(250);
        book.setStock(10);


        final Rent rent = new Rent();
        rent.setStartDate(LocalDate.now());
        rent.getBooks().add(book);


        rentService.deleteAll();

        rentService.add(rent);

        List<RentDTO> rents = rentService.getAll();

        for (RentDTO getRent : rents){

            if (getRent != null){

                int pageSum = 0;

                for (Book book1 : rent.getBooks()) {
                    pageSum += book1.getPage();
                }

                int pageNumForADay = 5;

                LocalDate expected1 = LocalDate.now().plusDays( pageSum / pageNumForADay );

                LocalDate actual = getRent.getFinishDate();
                assertEquals(actual , expected1);


                Set<BookDTO> booksDTO = getRent.getBooks();
                int sumStock = 0;

                for (BookDTO book1 : booksDTO){
                    sumStock+=book1.getStock();

                }

                int expected2 = 9;

                assertEquals(sumStock, expected2);

            }
        }

    }



}