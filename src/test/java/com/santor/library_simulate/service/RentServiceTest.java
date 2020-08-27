package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentServiceTest {

    private RentService rentService = Mockito.mock(RentService.class) ;

    private Rent rent ;


    @Test
    void add() throws Exception {


        rentService.add(rent);

        Mockito.verify (rentService).add(rent);

    }

    @Test
    void update() throws Exception {



        rentService.update(rent);

        Mockito.verify (rentService).update(rent);

    }

    @Test
    void deleteById() throws Exception {



        rentService.deleteById(rent.getId());

        Mockito.verify (rentService).deleteById(rent.getId());

    }

    @Test
    void deleteAll() throws Exception {



        rentService.deleteAll();

        Mockito.verify (rentService).deleteAll();

    }



    @Test
    void getById() throws Exception {



        rentService.getById(rent.getId());

        Mockito.verify (rentService).getById(rent.getId());

    }


    @Test
    void deleteAllById() throws Exception {


        List rents = null;
        rents.add(rent.getId()) ;

        rentService.deleteAllById(rents);

        Mockito.verify (rentService).deleteAllById(rents);

    }


    @Test
    void getAllById() throws Exception {


        List rents = null;
        rents.add(rent.getId()) ;


        rentService.getAllById(rents);

        Mockito.verify (rentService).getAllById(rents);

    }


    @Test
    void getAll() throws Exception {



        rentService.getAll();

        Mockito.verify (rentService).getAll();

    }



}