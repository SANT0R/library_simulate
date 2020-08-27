package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.mapper.RentMapper;
import com.santor.library_simulate.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;
    private RentMapper rentMapper;

    @Override
    public List<RentDTO> getAll() {

        return rentMapper.toDTOList(rentRepository.findAll());
    }

    @Override
    public List<RentDTO> getAllById(Iterable ids) {


        return rentMapper.toDTOList(rentRepository.findAllById(ids));
    }

    @Override
    public void deleteAllById(Iterable ids) {

        rentRepository.deleteAll(rentRepository.findAll());

    }

    @Override
    public RentDTO getById(Long id) {

        return rentMapper.toDTO (rentRepository.getOne(id));
    }

    @Override
    public void add(Rent rent) {

        rentRepository.save(rent);

    }

    @Override
    public void deleteAll() {

        rentRepository.deleteAll();

    }

    @Override
    public void deleteById(Rent rent) {

        rentRepository.delete(rent);

    }

    @Override
    public void update(Rent rent) {

        rentRepository.save(rent);

    }

}