package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientServiceTest {

    private ClientService clientService = Mockito.mock(ClientService.class) ;
    private Client client = Mockito.mock(Client.class) ;



    @Test
    void add(){


        clientService.add(client);

        Mockito.verify (clientService).add(client);

    }

    @Test
    void update(){



        clientService.update(client);

        Mockito.verify (clientService).update(client);

    }

    @Test
    void deleteById(){



        clientService.deleteById(client.getId());

        Mockito.verify (clientService).deleteById(client.getId());

    }

    @Test
    void deleteAll(){



        clientService.deleteAll();

        Mockito.verify (clientService).deleteAll();

    }


    @Test
    void deleteByName(){



        clientService.deleteByName(client.getFullName());

        Mockito.verify (clientService).deleteByName(client.getFullName());

    }


    @Test
    void getByName(){



        clientService.getByName(client.getFullName());

        Mockito.verify (clientService).getByName(client.getFullName());

    }


    @Test
    void getById(){



        clientService.getById(client.getId());

        Mockito.verify (clientService).getById(client.getId());

    }



    @Test
    void getAll(){



        clientService.getAll();

        Mockito.verify (clientService).getAll();

    }



}