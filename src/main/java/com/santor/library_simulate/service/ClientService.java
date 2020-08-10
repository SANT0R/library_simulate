package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAllClients();
    void addClient(Client client);

}
