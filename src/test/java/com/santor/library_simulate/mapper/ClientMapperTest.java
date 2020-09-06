package com.santor.library_simulate.mapper;

import com.santor.library_simulate.dto.ClientDTO;
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
class ClientMapperTest {

    @Spy
    ClientMapperImpl entityMapperImpl;


    private Client addEntity(Long id,String fullName){

        Author author = new Author();
        author.setId(20L);
        author.setFullName("dsfgh fghn");

        Book book = new Book();
        book.setId(id);
        book.setFullName(fullName);
        book.setType("sadfsd");
        book.setDescription("dsfgash");
        book.setPublisher("dfghj dsdf");
        book.setReleaseYear(LocalDate.now());
        book.setPage(800);
        book.setStock(800);

        author.getBooks().add(book);

        Client client = new Client();
        client.setId(id);
        client.setEMail("alskdmlaks@gmail.com");
        client.setFullName(fullName);
        client.setPassword("1234");
        client.setPhone("30203320");

        Rent rent = new Rent();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());
        rent.setClient(client);
        rent.getBooks().add(book);

        client.getRents().add(rent);


        return client;
    }

    @Test
    void toDTOTest() {


        Client entity = addEntity(20L,"Mehmet Santor");


        ClientDTO entityDTO = entityMapperImpl.toDTO(entity);
        assertEquals(entityDTO.getId(), entity.getId());
    }


    @Test
    void toDTOListTest() {


        Client entity1 = addEntity(20L,"Mehmet Santor");


        Client entity2 = addEntity(30L,"Mehmet asdfg");


        List<Client> entities = Arrays.asList(entity1, entity2);

        List<ClientDTO> entityDTOList = entityMapperImpl.toDTOList(entities);
        assertEquals(entityDTOList.get(0).getId(), entity1.getId());
        assertEquals(entityDTOList.get(1).getId(), entity2.getId());
    }


    @Test
    void toEntityTest() {


        Client entity = addEntity(20L,"Mehmet Santor");


        ClientDTO entityDTO = entityMapperImpl.toDTO(entity);

        Client entity1 = entityMapperImpl.toEntity(entityDTO);

        assertEquals(entity1.getId(), entityDTO.getId());

    }

    @Test
    void toEntityListTest() {


        Client entity1 = addEntity(20L,"Mehmet Santor");


        Client entity2 = addEntity(30L,"Mehmet asdfg");


        List<Client> entities = Arrays.asList(entity1, entity2);

        List<ClientDTO> entityDTOList = entityMapperImpl.toDTOList(entities);

        List<Client> entityList = entityMapperImpl.toEntityList(entityDTOList);


        assertEquals(entityDTOList.get(0).getId(), entityList.get(0).getId());
        assertEquals(entityDTOList.get(1).getId(), entityList.get(1).getId());
    }

}