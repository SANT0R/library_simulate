package com.santor.library_simulate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.dao.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {

        List<Client> ClientList = new ArrayList<>();
        clientRepository.findAll().forEach(ClientList::add);
        return ClientList;
    }

    public Client addClient(Client client) {

        client = clientRepository.save(client);

        return client;
    }

}