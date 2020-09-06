package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.RentMapper;
import com.santor.library_simulate.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository entityRepository;
    private RentMapper entityMapper;

    @Override
    public void add(Rent rent) {

        entityRepository.save(rent);

    }

    @Override
    public void update(Rent rent) {

        Rent entity = entityRepository.getOne(rent.getId());
        if (entity.getId() != null) {

            entityRepository.save(rent);

        }
        else {

            throw new ApiRequestException("Rent not found");
        }

    }

    @Override
    public List<RentDTO> getAll() {


        return entityMapper.toDTOList(entityRepository.findAll());
    }



    @Override
    public RentDTO getById(Long id) {

        try {

            Rent entity = entityRepository.getOne(id);
            return entityMapper.toDTO (entity);
        }
        catch (EntityNotFoundException e){

            throw new ApiRequestException("Rent not found");
        }

    }


    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        try {

            Rent entity = entityRepository.getOne(id);
            entityRepository.delete(entity);
        }
        catch (EntityNotFoundException e){

            throw new ApiRequestException("Rent not found");
        }


    }


}