package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface RentService {
    List<RentDTO> getAll();

    RentDTO getById(Long id);

    void deleteAll();

    void deleteById(Long id);

    void update(Rent rent);

    void add(Rent rent);

}
