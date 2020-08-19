package com.santor.library_simulate.dao;

import com.santor.library_simulate.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santor.library_simulate.model.Rent;

import java.util.List;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {


}