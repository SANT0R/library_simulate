package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RentRepositoryTest {

    @Autowired
    private RentRepository entityRepository ;
    @Autowired
    private BookRepository bookRepository ;

    Long firstId = 448L; //deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.

    private void addEntity(){

        Rent entity = new Rent();
        entity.setStartDate(LocalDate.now());
        entity.setFinishDate(LocalDate.now());

        Set<Book> books = new HashSet<>();

        Book book1 = new Book();
        book1.setId(295L);
        books.add(book1);
        Book book2 = new Book();
        book2.setId(296L);
        books.add(book2);
        Book book3 = new Book();
        book3.setId(297L);
        books.add(book3);

        entity.setBooks(books);
        entityRepository.save(entity);
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity();


        Rent entity = entityRepository.getOne(firstId);
        assertEquals(entity.getId(), firstId);

    }


    @Test
    void deleteByIdTest(){//"firstId" deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.


        entityRepository.deleteAll();

        firstId++;

        addEntity();

        entityRepository.deleteById(firstId);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();

        addEntity();


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity();
        Rent entity = entityRepository.getOne(firstId);

        assertEquals(entity.getId(), firstId);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity();

        addEntity();

        addEntity();


        assertEquals(entityRepository.count(), 3);

        Rent entity1 = entityRepository.getOne(firstId);

        assertEquals(entity1.getId(), firstId);

        Rent entity2 = entityRepository.getOne(firstId+1);

        assertEquals(entity2.getId(), firstId+1);

        Rent entity3 = entityRepository.getOne(firstId+2);

        assertEquals(entity3.getId(), firstId+2);
    }



}
