package com.santor.library_simulate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Client;
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