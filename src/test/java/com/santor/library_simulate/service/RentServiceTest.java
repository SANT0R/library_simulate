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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {


    @Spy
    private RentMapperImpl rentMapper;
    //
    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentServiceImpl rentService;
//    private Rent rent = Mockito.mock(Rent.class) ;

    Rent setRent(){
        Rent rent = new Rent();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());

        Book book = new Book();
        book.setFullName("Facebook");
        book.setPage(800);

        Author author = new Author();
        author.setId(2L);
        author.setFullName("Mehmet Santor");
        author.getBooks().add(book);

        Client client = new Client();
        client.setEMail("alskdmlaks@gmail.com");
        client.setFullName("msantor");
        client.setPassword("1234");
        client.setPhone("30203320");

        rent.setClient(client);
        rent.getBooks().add(book);

        client.getRents().add(rent);

        return rent;
    }


//
//    @Test
//    void add() throws Exception {
//
//        whe
//        rentService.add(rent);
//
//        verify (rentService).add(rent);
//
//    }
//
//    @Test
//    void update() throws Exception {
//
//
//
//        rentService.update(rent);
//
//        verify (rentService).update(rent);
//
//    }
//
//    @Test
//    void deleteById() throws Exception {
//
//
//
//        rentService.deleteById(rent.getId());
//
//        verify (rentService).deleteById(rent.getId());
//
//    }
//
//    @Test
//    void deleteAll() throws Exception {
//
//
//
//        rentService.deleteAll();
//
//        verify (rentService).deleteAll();
//
//    }


    @Test
    void getById() {


        Rent rent = setRent();

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



//    @Test
//    void getAll() throws Exception {
//
//
//
//        rentService.getAll();
//
//        verify (rentService).getAll();
//
//    }


}