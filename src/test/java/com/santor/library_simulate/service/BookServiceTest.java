package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.BookRepository;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.mapper.BookMapperImpl;
import com.santor.library_simulate.model.Book;
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
class BookServiceTest {


    @Spy
    private BookMapperImpl entityMapper;

    @Mock
    private BookRepository entityRepository;

    @InjectMocks
    private BookServiceImpl entityService;




    @Test
    void getByNameTest() {
        final Book entity1 = new Book();
        entity1.setFullName("Konyalı");

        entityService.add(entity1);

        final Book entity2 = new Book();
        entity2.setFullName("Urfalıyam Ezelden");

        entityService.add(entity2);

        final Book entity3 = new Book();
        entity3.setFullName("Ağrılı Halo");

        entityService.add(entity3);

        final Book entity4 = new Book();
        entity4.setFullName("ya");

        entityService.add(entity4);

        List<BookDTO> entities = entityService.getByName("ya");

        List<BookDTO> expected = new ArrayList<>();
        expected.add(entityMapper.toDTO(entity1));
        expected.add(entityMapper.toDTO(entity2));
        expected.add(entityMapper.toDTO(entity4));


        assertEquals(expected, entities);

    }

}