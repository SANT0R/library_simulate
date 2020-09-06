package com.santor.library_simulate.dao;


import com.santor.library_simulate.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    Client findByFullName(String fullName);


}