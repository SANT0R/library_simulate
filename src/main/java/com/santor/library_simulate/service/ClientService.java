package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getByName(String fullName);

    List<ClientDTO> getAll();

    ClientDTO getById(Long id);

    void deleteAll();

    void deleteById(Long id);

    void deleteByName(String fullName);

    void update(Client client);

    void add(Client client);

}
