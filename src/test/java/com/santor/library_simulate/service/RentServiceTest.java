package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Rent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RentServiceTest {

    private RentService rentService = Mockito.mock(RentService.class) ;
    private Rent rent = Mockito.mock(Rent.class) ;



    @Test
    void add(){


        rentService.add(rent);

        Mockito.verify (rentService).add(rent);

    }

    @Test
    void update(){



        rentService.update(rent);

        Mockito.verify (rentService).update(rent);

    }

    @Test
    void deleteById(){



        rentService.deleteById(rent.getId());

        Mockito.verify (rentService).deleteById(rent.getId());

    }

    @Test
    void deleteAll(){



        rentService.deleteAll();

        Mockito.verify (rentService).deleteAll();

    }



    @Test
    void getById(){



        rentService.getById(rent.getId());

        Mockito.verify (rentService).getById(rent.getId());

    }



    @Test
    void getAll(){



        rentService.getAll();

        Mockito.verify (rentService).getAll();

    }



}