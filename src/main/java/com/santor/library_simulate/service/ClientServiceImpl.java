package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.ClientRepository;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.ClientMapper;
import com.santor.library_simulate.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository entityRepository;
    private ClientMapper entityMapper;


    @Override
    public void add(ClientDTO client) {


        entityRepository.save(entityMapper.toEntity(client));

    }

    @Override
    public void update(ClientDTO client) {

        Client entity = entityRepository.getOne(client.getId());
        if (entity.getId() != null) {

            entityRepository.save(entityMapper.toEntity(client));

        } else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public List<ClientDTO> getAll() {


        return entityMapper.toDTOList(entityRepository.findAll());
    }


    @Override
    public ClientDTO getById(Long id) {

        Client entity = entityRepository.getOne(id);

        if (entity != null){

            return entityMapper.toDTO(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public List<ClientDTO> getByName(String fullName) {

        List<Client> clients = entityRepository.findByFullNameContains(fullName);

        return entityMapper.toDTOList (clients);

    }

    @Override
    public void deleteByName(String fullName) {


        Client entity = entityRepository.findByFullName(fullName);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        Client entity = entityRepository.getOne(id);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }


    }
}