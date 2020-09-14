package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Mock
    private RentRepository rentRepository;


    @InjectMocks
    private RentServiceImpl rentService;

    private Book addBook(Long id, int pageNum, int stock){

        Book entity = new Book();
        entity.setId(id);
        entity.setFullName("fullName");
        entity.setType("sadfsd");
        entity.setDescription("dsfgash");
        entity.setPublisher("dfghj dsdf");
        entity.setReleaseYear(LocalDate.now());
        entity.setPage(pageNum);
        entity.setStock(stock);

        return entity;
    }

    private Rent addEntity(){

        Rent entity = new Rent();
        entity.setId(20L);
        entity.setStartDate(LocalDate.now());
        entity.getBooks().add(addBook(2L,245,13));
        entity.getBooks().add(addBook(4L,148,100));
        entity.getBooks().add(addBook(3L,763,7));

        rentService.add(entity);

        return entity;
    }



    @Test
    void addTest() {

        Rent rentAdd = addEntity();

        LocalDate actual1 = rentAdd.getFinishDate() ;
        LocalDate expected1 = LocalDate.now().plusDays((245+763+148)/5);

        assertEquals(actual1, expected1);

        Set<Book> books = rentAdd.getBooks();

        List<Integer> expected2 = new ArrayList<>();
        expected2.add (12);
        expected2.add (99);
        expected2.add (6);


        List<Integer> actual2 = new ArrayList<>();

        for (Book book :books){

            actual2.add(book.getStock()) ;
        }

        assertEquals(expected2,actual2 );

        Mockito.verify(rentRepository, Mockito.times(1)).save(rentAdd);

    }

}