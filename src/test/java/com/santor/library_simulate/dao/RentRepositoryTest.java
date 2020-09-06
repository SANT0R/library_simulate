package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RentRepositoryTest {

    @Autowired
    private RentRepository entityRepository ;

    private void addEntity(Long id){

        Rent entity = new Rent();
        entity.setId(id);
        entity.setStartDate(LocalDate.now());
        entity.setFinishDate(LocalDate.now());

        entityRepository.save(entity);
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        addEntity(20L);


        Rent entity = entityRepository.getOne(20L);
        assertEquals(entity.getId(), 20L);

    }


    @Test
    void deleteByIdTest(){

        entityRepository.deleteAll();

        addEntity(10L);


        entityRepository.deleteById(10L);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();

        addEntity(20L);


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        addEntity(20L);
        Rent entity = entityRepository.getOne(20L);

        assertEquals(entity.getId(), 20L);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        addEntity(20L);

        addEntity(30L);

        addEntity(40L);


        assertEquals(entityRepository.count(), 3);

        Rent entity1 = entityRepository.getOne(20L);

        assertEquals(entity1.getId(), 20L);

        Rent entity2 = entityRepository.getOne(30L);

        assertEquals(entity2.getId(), 30L);

        Rent entity3 = entityRepository.getOne(40L);

        assertEquals(entity3.getId(), 40L);
    }



}
