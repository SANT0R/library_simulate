package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.RentMapper;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository entityRepository;
    private RentMapper entityMapper;

    @Override
    public void add(Rent rent) {

        int pageSum = 0;
        for (Book book : rent.getBooks()) {
            pageSum += book.getPage();

            List<Long> bookIds = new ArrayList<>();

            for (Long id : bookIds) {
                if (book.getId()==null){

                    throw new ApiRequestException(book.getFullName()+
                            " adlı kitap bulunamadığı için kiralama işlemi tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);
                }
                if (book.getId().equals(id)) {

                    throw new ApiRequestException(book.getFullName()+
                            " kitabından birden fazla eklediğiniz için kiralama işlemi tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

                }
                if (book.getStock()==0){
                    
                    throw new ApiRequestException(book.getFullName()+
                            " kitabı stokta bulunmadığı için kiralama işlemi tamamlanamadı.", HttpStatus.NOT_FOUND);
                }
                else {
                    book.setStock(book.getStock()-1);
                }
            }
            bookIds.add(book.getId());
        }


        rent.setFinishDate(rent.getStartDate().plusDays(pageSum/5));

        entityRepository.save(rent);
    }

    @Override
    public void update(Rent rent) {

        Rent entity = entityRepository.getOne(rent.getId());
        if (entity.getId() != null) {

            entityRepository.save(rent);

        }
        else {

            throw new ApiRequestException(rent.getId()+
                    " id numaralı kira bulunamadığı için işleminiz tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

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

            throw new ApiRequestException(id+
                    " id numaralı kira bulunamadığı için işleminiz tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

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

            throw new ApiRequestException(id+
                    " id numaralı kira bulunamadığı için işleminiz tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

        }


    }


}