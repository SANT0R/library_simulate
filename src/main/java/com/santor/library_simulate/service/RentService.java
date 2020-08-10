package com.santor.library_simulate.service;

import com.santor.library_simulate.model.Rent;

import java.util.List;

public interface RentService {

    List<Rent> getAllRents();
    Rent addRent(Rent rent);

}
