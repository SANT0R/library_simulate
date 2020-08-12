package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAll();
    List<ClientDTO> getAllById(List ids);
    ClientDTO getById(Long id);
    void deleteAllById(List ids);
    void deleteAll();
    void deleteById(Client client);
    void update(Client client);
    void add(Client client);

}
