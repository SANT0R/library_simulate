package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client addClient(Client client);

}
