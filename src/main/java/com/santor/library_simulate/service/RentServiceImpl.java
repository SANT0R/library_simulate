package com.santor.library_simulate.service;

import java.util.ArrayList;
import java.util.List;

import com.santor.library_simulate.dto.RentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santor.library_simulate.model.Rent;
import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.mapper.RentMapper;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;
    private RentMapper rentMapper;

    public List<RentDTO> getAllRents() {

        List<Rent> bookList = new ArrayList<>();
        rentRepository.findAll().forEach(bookList::add);

        return rentMapper.toDTOList(bookList);
    }

    public void addRent(Rent rent) {

        rent = rentRepository.save(rent);

    }

}