package com.santor.library_simulate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        List<Rent> rentList = new ArrayList<>();
        rentRepository.findAll().forEach(rentList::add);

        return rentMapper.toDTOList(rentList);
    }

    public List<RentDTO> getByIds(List ids) {

        List<Rent> rentList = new ArrayList<>();
        rentRepository.findAllById(ids).forEach(rentList::add);

        return rentMapper.toDTOList(rentList);
    }
    
    public RentDTO getById(Long id) {

        Optional<Rent> optionalRent =  rentRepository.findById(id);
        Rent rent = optionalRent.get();

        return rentMapper.toDTO (rent);
    }

    public void addRent(Rent rent) {

        rent = rentRepository.save(rent);

    }

}