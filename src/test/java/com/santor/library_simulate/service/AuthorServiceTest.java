package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.AuthorRepository;
import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.mapper.AuthorMapperImpl;
import com.santor.library_simulate.model.Author;
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
class AuthorServiceTest {


    @Spy
    private AuthorMapperImpl entityMapper;

    @Mock
    private AuthorRepository entityRepository;

    @InjectMocks
    private AuthorServiceImpl entityService;


    @Test
    void getByNameTest() {
        Author entity1 = new Author();
        entity1.setFullName("konyalı");

        entityRepository.save(entity1);

        Author entity2 = new Author();
        entity2.setFullName("urfalıyam ezelden");

        entityRepository.save(entity2);

        Author entity3 = new Author();
        entity3.setFullName("ağrılı halo");

        entityRepository.save(entity3);

        Author entity4 = new Author();
        entity4.setFullName("ya");

        entityRepository.save(entity4);

        List<AuthorDTO> entities = entityService.getByName("ya");

        List<AuthorDTO> expected = new ArrayList<>();
        expected.add(entityMapper.toDTO(entity1));
        expected.add(entityMapper.toDTO(entity2));
        expected.add(entityMapper.toDTO(entity4));


        assertEquals(entities, expected);

    }

}