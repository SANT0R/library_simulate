package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository entityRepository ;

    Long firstId = 418L; //deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.

    private Book addEntity(String fullName){

        Book entity = new Book();
        entity.setFullName(fullName);
        entity.setType("sadfsd");
        entity.setDescription("dsfgash");
        entity.setPublisher("dfghj dsdf");
        entity.setReleaseYear(LocalDate.now());
        entity.setPage(800);
        entity.setStock(800);

        entityRepository.save(entity);
        return entity;
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        firstId++;


        addEntity("Mehmet Santor");


        Book entity = entityRepository.getOne(firstId);
        assertEquals(entity.getId(), firstId);

    }


    @Test
    void deleteByIdTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity("Mehmet Santor");


        entityRepository.deleteById(firstId);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();


        addEntity("Mehmet Santor");


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void deleteByNameTest(){

        entityRepository.deleteAll();

        addEntity("Mehmet Santor");



        assertEquals(entityRepository.count(),1);

        entityRepository.delete(entityRepository.findByFullName("Mehmet Santor"));


        assertEquals(entityRepository.count(),0);


    }


    @Test
    void getByNameTest(){

        entityRepository.deleteAll();

        addEntity("Mehmet Santor");

        Book  entity = entityRepository.findByFullName("Mehmet Santor");

        assertEquals(entity.getFullName(),"Mehmet Santor" );

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity("Mehmet Santor");
        Book entity = entityRepository.getOne(firstId);

        assertEquals(entity.getId(), firstId);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity("Konyalı");

        addEntity("Urfalıyam Ezelden");

        addEntity("Ağrılı halo");

        addEntity("ya");


        assertEquals(entityRepository.count(), 4);

        Book entity1 = entityRepository.getOne(firstId);

        assertEquals(entity1.getId(), firstId);

        Book entity2 = entityRepository.getOne(firstId+1);

        assertEquals(entity2.getId(), firstId+1);

        Book entity3 = entityRepository.getOne(firstId+2);

        assertEquals(entity3.getId(), firstId+2);

        Book entity4 = entityRepository.getOne(firstId+3);

        assertEquals(entity4.getId(), firstId+3);
    }

    @Test
    void searchTest(){
        entityRepository.deleteAll();

        List<Book> expected = new ArrayList<>();
        expected.add(addEntity("Konyalı"));
        expected.add(addEntity("Urfalıyam Ezelden"));
        addEntity("Ağrılı halo");
        expected.add(addEntity("ya"));

        List<Book> actual = entityRepository.findByFullNameContains("ya");

        assertTrue(actual != null && actual.size() == 3);
        //assertEquals(expected,actual);

    }

}
