package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface RentService {
    List<RentDTO> getAll();
    List<RentDTO> getAllById(Iterable ids);
    RentDTO getById(Long id);
    void deleteAllById(Iterable ids);
    void deleteAll();
    void deleteById(Long id);
    void update(Rent rent);
    void add(Rent rent);

}
