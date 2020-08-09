package com.santor.library_simulate.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santor.library_simulate.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}