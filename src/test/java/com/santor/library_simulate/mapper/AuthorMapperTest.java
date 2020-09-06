package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.AuthorDTO;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AuthorMapperTest {

    @Spy
    AuthorMapperImpl entityMapperImpl;


    private Author addEntity(Long id,String fullName){
        Rent rent = new Rent();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());

        Book book = new Book();
        book.setFullName("Facebook");
        book.setPage(800);

        Author author = new Author();
        author.setId(id);
        author.setFullName(fullName);
        author.getBooks().add(book);

        Client client = new Client();
        client.setEMail("alskdmlaks@gmail.com");
        client.setFullName("msantor");
        client.setPassword("1234");
        client.setPhone("30203320");

        rent.setClient(client);
        rent.getBooks().add(book);

        client.getRents().add(rent);

        return author;
    }

    @Test
    void toDTOTest() {


        Author entity = addEntity(20L,"Mehmet Santor");


        AuthorDTO entityDTO = entityMapperImpl.toDTO(entity);
        assertEquals(entityDTO.getId(), entity.getId());
    }


    @Test
    void toDTOListTest() {


        Author entity1 = addEntity(20L,"Mehmet Santor");


        Author entity2 = addEntity(30L,"Mehmet asdfg");


        List<Author> entities = Arrays.asList(entity1, entity2);

        List<AuthorDTO> entityDTOList = entityMapperImpl.toDTOList(entities);
        assertEquals(entityDTOList.get(0).getId(), entity1.getId());
        assertEquals(entityDTOList.get(1).getId(), entity2.getId());
    }


    @Test
    void toEntityTest() {


        Author entity = addEntity(20L,"Mehmet Santor");


        AuthorDTO entityDTO = entityMapperImpl.toDTO(entity);

        Author entity1 = entityMapperImpl.toEntity(entityDTO);

        assertEquals(entity1.getId(), entityDTO.getId());

    }

    @Test
    void toEntityListTest() {


        Author entity1 = addEntity(20L,"Mehmet Santor");


        Author entity2 = addEntity(30L,"Mehmet asdfg");


        List<Author> entities = Arrays.asList(entity1, entity2);

        List<AuthorDTO> entityDTOList = entityMapperImpl.toDTOList(entities);

        List<Author> entityList = entityMapperImpl.toEntityList(entityDTOList);


        assertEquals(entityDTOList.get(0).getId(), entityList.get(0).getId());
        assertEquals(entityDTOList.get(1).getId(), entityList.get(1).getId());
    }

}