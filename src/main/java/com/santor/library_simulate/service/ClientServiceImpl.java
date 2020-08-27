package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.mapper.ClientMapper;
import com.santor.library_simulate.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAll() {


        return clientMapper.toDTOList(clientRepository.findAll());
    }


    @Override
    public ClientDTO getById(Long id) {


        return clientMapper.toDTO (clientRepository.getOne(id));
    }

    @Override
    public List<ClientDTO> getByName(String fullName) {


        return clientMapper.toDTOList (clientRepository.findByFullName(fullName));
    }

    @Override
    public void deleteByName(String fullName) {


        clientRepository.deleteAll(clientRepository.findByFullName(fullName));
    }

    @Override
    public void add(Client client) {

        clientRepository.save(client);

    }

    @Override
    public void deleteAll( ) {

        clientRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        clientRepository.deleteById(id);

    }

    @Override
    public void update(Client client) {

        clientRepository.save(client);

    }

}