package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ClientServiceTest {

    private ClientService clientService = Mockito.mock(ClientService.class) ;

    private  Client client ;

    ClientServiceTest(Client client) {
        this.client = client;
    }


    @Test
    void add() throws Exception {


        clientService.add(client);

        Mockito.verify (clientService).add(client);

    }

    @Test
    void update() throws Exception {



        clientService.update(client);

        Mockito.verify (clientService).update(client);

    }

    @Test
    void deleteById() throws Exception {



        clientService.deleteById(client.getId());

        Mockito.verify (clientService).deleteById(client.getId());

    }

    @Test
    void deleteAll() throws Exception {



        clientService.deleteAll();

        Mockito.verify (clientService).deleteAll();

    }


    @Test
    void deleteByName() throws Exception {



        clientService.deleteByName(client.getFullName());

        Mockito.verify (clientService).deleteByName(client.getFullName());

    }


    @Test
    void getByName() throws Exception {



        clientService.getByName(client.getFullName());

        Mockito.verify (clientService).getByName(client.getFullName());

    }


    @Test
    void getById() throws Exception {



        clientService.getById(client.getId());

        Mockito.verify (clientService).getById(client.getId());

    }


    @Test
    void deleteAllById() throws Exception {


        List clients = null;
        clients.add(client.getId()) ;

        clientService.deleteAllById(clients);

        Mockito.verify (clientService).deleteAllById(clients);

    }


    @Test
    void getAllById() throws Exception {


        List clients = null;
        clients.add(client.getId()) ;


        clientService.getAllById(clients);

        Mockito.verify (clientService).getAllById(clients);

    }


    @Test
    void getAll() throws Exception {



        clientService.getAll();

        Mockito.verify (clientService).getAll();

    }



}