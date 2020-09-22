package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ClientService {

    /**
     * Get all clients
     * @return List<ClientDTO>
     */
    List<ClientDTO> getAll();

    /**
     * Get a client by id
     * @param id -
     * @return ClientDTO
     */
    ClientDTO getById(Long id);

    /**
     * Get a client by full name
     * @param fullName -
     * @return List<ClientDTO>
     */
    List<ClientDTO> getByName(String fullName);

    /**
     * Delete all clients
     */
    void deleteAll();

    /**
     * Delete a client by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a client by name
     * @param fullName -
     */
    void deleteByName(String fullName);

    /**
     * Update a client
     * @param client -
     */
    void update(Client client);

    /**
     * Add a client
     * @param client -
     */
    void add(Client client);

}
