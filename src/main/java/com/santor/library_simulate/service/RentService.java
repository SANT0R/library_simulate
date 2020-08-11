package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface RentService {

    List<RentDTO> getAllRents();
    List<RentDTO> getByIds(List ids);
    void addRent(Rent rent);

}
