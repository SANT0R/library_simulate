package com.santor.library_simulate.dao;

import com.santor.library_simulate.config.security.ApiUserRole;
import com.santor.library_simulate.model.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository entityRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    Long firstId = 418L; //deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.

    private Client addEntity(String fullName){

        Client entity = new Client();
        entity.setFullName(fullName);
        entity.setUserName(fullName);
        entity.setPassword(passwordEncoder.encode("Santor123"));
        entity.setRole(ApiUserRole.ADMIN);
        entity.setEMail("sdfd");
        entity.setPhone("45296656");

        entityRepository.save(entity);
        return entity;
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity("Santor");


        Client entity = entityRepository.getOne(firstId);
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

        Client  entity = entityRepository.findByFullName("Mehmet Santor");

        assertEquals(entity.getFullName(),"Mehmet Santor" );

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity("Mehmet Santor");
        Client entity = entityRepository.getOne(firstId);

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

        Client entity1 = entityRepository.getOne(firstId);

        assertEquals(entity1.getId(), firstId);

        Client entity2 = entityRepository.getOne(firstId+1);

        assertEquals(entity2.getId(), firstId+1);

        Client entity3 = entityRepository.getOne(firstId+2);

        assertEquals(entity3.getId(), firstId+2);

        Client entity4 = entityRepository.getOne(firstId+3);

        assertEquals(entity4.getId(), firstId+3);
    }

    @Test
    void searchTest(){

        entityRepository.deleteAll();

        List<Client> expected = new ArrayList<>();
        expected.add(addEntity("Konyalı"));
        expected.add(addEntity("Urfalıyam Ezelden"));
        addEntity("Ağrılı halo");
        expected.add(addEntity("ya"));

        List<Client> actual = entityRepository.findByFullNameContains("ya");

        assertTrue(actual != null && actual.size() == 3);

        //assertEquals(expected,actual);
    }
}
