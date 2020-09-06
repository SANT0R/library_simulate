package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.ClientMapper;
import com.santor.library_simulate.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository entityRepository;
    private ClientMapper entityMapper;


    @Override
    public void add(Client client) {

        entityRepository.save(client);

    }

    @Override
    public void update(Client client) {

        Client entity = entityRepository.getOne(client.getId());
        if (entity.getId() != null) {

            entityRepository.save(client);

        } else {

            throw new ApiRequestException("Client not found");
        }

    }

    @Override
    public List<ClientDTO> getAll() {


        return entityMapper.toDTOList(entityRepository.findAll());
    }


    @Override
    public ClientDTO getById(Long id) {

        try {

            Client entity = entityRepository.getOne(id);
            return entityMapper.toDTO(entity);
        } catch (EntityNotFoundException e) {

            throw new ApiRequestException("Client not found");
        }

    }

    @Override
    public ClientDTO getByName(String fullName) {

        try {

            Client entity = entityRepository.findByFullName(fullName);
            return entityMapper.toDTO(entity);
        } catch (EntityNotFoundException e) {

            throw new ApiRequestException("Client not found");
        }
    }

    @Override
    public void deleteByName(String fullName) {


        try {

            Client entity = entityRepository.findByFullName(fullName);
            entityRepository.delete(entity);
        } catch (EntityNotFoundException e) {

            throw new ApiRequestException("Client not found");
        }

    }

    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        try {

            Client entity = entityRepository.getOne(id);
            entityRepository.delete(entity);
        } catch (EntityNotFoundException e) {

            throw new ApiRequestException("Client not found");
        }


    }
}