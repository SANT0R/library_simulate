package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository entityRepository ;

    private Author addEntity(Long id,String fullName){

        Author entity = new Author();
        entity.setId(id);
        entity.setFullName(fullName);

        entityRepository.save(entity);
        return entity;
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");


        Author entity = entityRepository.getOne(20L);
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

        Author  entity = entityRepository.findByFullName("Mehmet Santor");

        assertEquals(entity.getFullName(),"Mehmet Santor" );

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        addEntity(20L,"Mehmet Santor");
        Author entity = entityRepository.getOne(20L);

        assertEquals(entity.getId(), 20L);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        addEntity(20L,"Konyalı");
        addEntity(30L,"Urfalıyam Ezelden");
        addEntity(40L,"Ağrılı halo");
        addEntity(50L,"ya");


        assertEquals(entityRepository.count(), 4);

        Author entity1 = entityRepository.getOne(20L);

        assertEquals(entity1.getId(), 20L);

        Author entity2 = entityRepository.getOne(30L);

        assertEquals(entity2.getId(), 30L);

        Author entity3 = entityRepository.getOne(40L);

        assertEquals(entity3.getId(), 40L);

        Author entity4 = entityRepository.getOne(50L);

        assertEquals(entity4.getId(), 50L);
    }

    @Test
    void searchTest(){
        entityRepository.deleteAll();

        List<Author> expected = new ArrayList<>();
        expected.add(addEntity(20L,"Konyalı"));
        expected.add(addEntity(30L,"Urfalıyam Ezelden"));
        addEntity(40L,"Ağrılı halo");
        expected.add(addEntity(50L,"ya"));

        List<Author> actual = entityRepository.findByFullNameContains("ya");

        assertTrue(actual != null && actual.size() == 3);

    }

}
