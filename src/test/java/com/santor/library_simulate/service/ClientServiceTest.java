package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.mapper.ClientMapperImpl;
import com.santor.library_simulate.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {


    @Spy
    private ClientMapperImpl entityMapper;

    @Mock
    private ClientRepository entityRepository;

    @InjectMocks
    private ClientServiceImpl entityService;




    @Test
    void getByNameTest() {
        final Client entity1 = new Client();
        entity1.setFullName("Konyalı");

        entityService.add(entity1);

        final Client entity2 = new Client();
        entity2.setFullName("Urfalıyam Ezelden");

        entityService.add(entity2);

        final Client entity3 = new Client();
        entity3.setFullName("Ağrılı Halo");

        entityService.add(entity3);

        final Client entity4 = new Client();
        entity4.setFullName("ya");

        entityService.add(entity4);

        List<ClientDTO> entities = entityService.getByName("ya");//Boşş dizi dönderiyor.

        List<ClientDTO> expected = new ArrayList<>();
        expected.add(entityMapper.toDTO(entity1));
        expected.add(entityMapper.toDTO(entity2));
        expected.add(entityMapper.toDTO(entity4));


        assertEquals(expected, entities);

    }

}