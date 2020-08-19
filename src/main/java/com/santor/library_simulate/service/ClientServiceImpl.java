package com.santor.library_simulate.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Book;
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

    @Override
    public List<ClientDTO> getAll() {

        List<Client> clientList = new ArrayList<>();
        clientRepository.findAll().forEach(clientList::add);

        return clientMapper.toDTOList(clientList);
    }

    @Override
    public List<ClientDTO> getAllById(List ids) {

        List<Client> clientList = new ArrayList<>();
        clientRepository.findAllById(ids).forEach((Consumer) clientList);

        return clientMapper.toDTOList(clientList);
    }

    @Override
    public void deleteAllById(List ids) {

        List<Client> clientList = new ArrayList<>();
        clientRepository.findAllById(ids).forEach((Consumer) clientList);
        clientRepository.deleteAll(clientList);

    }

    @Override
    public ClientDTO getById(Long id) {

        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client = optionalClient.get();

        return clientMapper.toDTO (client);
    }

    @Override
    public List<ClientDTO> findByName(String fullName) {
        List<Client> clientList = clientRepository.findByFullName(fullName);

        return clientMapper.toDTOList (clientList);
    }

    @Override
    public void deleteByName(String fullName) {
        List<Client> clientList = clientRepository.findByFullName(fullName);
        clientRepository.deleteAll(clientList);
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
    public void deleteById(Client client) {

        clientRepository.delete(client);

    }

    @Override
    public void update(Client client) {

        clientRepository.save(client);

    }

}