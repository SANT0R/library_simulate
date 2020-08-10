package com.santor.library_simulate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Rent;
import com.santor.library_simulate.dao.RentRepository;

@Service
public class RentServiceImpl {

    @Autowired
    RentRepository rentRepository;

    public List<Rent> getAllRents() {

        List<Rent> RentList = new ArrayList<>();
        rentRepository.findAll().forEach(RentList::add);
        return RentList;
    }

    public Rent addRent(Rent rent) {

        rent = rentRepository.save(rent);

        return rent;
    }

}