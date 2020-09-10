package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.mapper.ClientMapperImpl;
import com.santor.library_simulate.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {



    @Mock
    private ClientMapperImpl entityMapper;

    @Mock
    private ClientRepository entityRepository;

    @InjectMocks
    private ClientServiceImpl entityService;




    @Test
    void getByNameTest() {
        Client entity1 = new Client();
        entity1.setFullName("konyalı");

        entityService.add(entity1);

        Client entity2 = new Client();
        entity2.setFullName("urfalıyam ezelden");

        entityService.add(entity2);

        Client entity3 = new Client();
        entity3.setFullName("ağrılı halo");

        entityService.add(entity3);

        Client entity4 = new Client();
        entity4.setFullName("ya");

        entityService.add(entity4);

        List<ClientDTO> entities = entityService.getByName("ya");

        List<ClientDTO> expected = new ArrayList<>();
        entities.add(entityMapper.toDTO(entity1));
        entities.add(entityMapper.toDTO(entity2));
        entities.add(entityMapper.toDTO(entity4));


        assertEquals(entities, expected);

    }



}