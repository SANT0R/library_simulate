package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.mapper.RentMapperImpl;
import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Mock
    private RentMapperImpl rentMapper;

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentServiceImpl rentService;




    @Test
    void getById() {
        Author author = new Author();
        author.setId(20L);
        author.setFullName("sdfghj dfghj");

        Book book = new Book();
        book.setId(2L);
        book.setFullName("asdfgh dfgd");
        book.setType("sadfsd");
        book.setDescription("dsfgash");
        book.setPublisher("dfghj dsdf");
        book.setReleaseYear(LocalDate.now());
        book.setPage(800);
        book.setStock(800);

        author.getBooks().add(book);

        Client client = new Client();
        client.setId(30L);
        client.setEMail("alskdmlaks@gmail.com");
        client.setFullName("msantor");
        client.setPassword("1234");
        client.setPhone("30203320");

        Rent rent = new Rent();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());
        rent.setClient(client);
        rent.getBooks().add(book);

        client.getRents().add(rent);


//        RentDTO rentDTO = rentMapper.toDTO(rent);
//        assertTrue(rentDTO != null);
        when(rentRepository.getOne(20L)).thenReturn(rent);
        RentDTO rentDTO=new RentDTO();
        rentDTO.setId(20L);
        when(rentMapper.toDTO(rent)).thenReturn(rentDTO);

        RentDTO expected = rentService.getById(20L);

//        verify (rentRepository).getOne(anyLong());

        assertEquals(expected.getId(), 20L);
    }



}