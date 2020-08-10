package com.santor.library_simulate.service;



import java.util.ArrayList;
import java.util.List;

import com.santor.library_simulate.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.mapper.ClientMapper;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public List<ClientDTO> getAllClients() {

        List<Client> clientList = new ArrayList<>();
        clientRepository.findAll().forEach(clientList::add);

        return clientMapper.toDTOList(clientList);
    }

    public void addClient(Client client) {

        client = clientRepository.save(client);


    }

}