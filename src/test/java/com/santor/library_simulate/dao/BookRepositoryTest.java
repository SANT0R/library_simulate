package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository entityRepository ;

    private void addEntity(Long id,String fullName){

        Book entity = new Book();
        entity.setId(id);
        entity.setFullName(fullName);
        entity.setType("sadfsd");
        entity.setDescription("dsfgash");
        entity.setPublisher("dfghj dsdf");
        entity.setReleaseYear(LocalDate.now());
        entity.setPage(800);
        entity.setStock(800);

        entityRepository.save(entity);
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");


        Book entity = entityRepository.getOne(20L);
        assertEquals(entity.getId(), 20L);

    }


    @Test
    void deleteByIdTest(){

        entityRepository.deleteAll();

        addEntity(10L,"Mehmet Santor");


        entityRepository.deleteById(10L);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void deleteByNameTest(){

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");



        assertEquals(entityRepository.count(),1);

        entityRepository.delete(entityRepository.findByFullName("Mehmet Santor"));


        assertEquals(entityRepository.count(),0);


    }


    @Test
    void getByNameTest(){

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");

        Book  entity = entityRepository.findByFullName("Mehmet Santor");

        assertEquals(entity.getFullName(),"Mehmet Santor" );

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");
        Book entity = entityRepository.getOne(20L);

        assertEquals(entity.getId(), 20L);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");

        addEntity(30L,"asghdf sadfg");

        addEntity(40L,"fgd dfghr");


        assertEquals(entityRepository.count(), 3);

        Book entity1 = entityRepository.getOne(20L);

        assertEquals(entity1.getId(), 20L);

        Book entity2 = entityRepository.getOne(30L);

        assertEquals(entity2.getId(), 30L);

        Book entity3 = entityRepository.getOne(40L);

        assertEquals(entity3.getId(), 40L);
    }



}
