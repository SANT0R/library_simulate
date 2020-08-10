package com.santor.library_simulate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santor.library_simulate.model.Rent;
import com.santor.library_simulate.service.RentServiceImpl;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentServiceImpl rentService;

    @GetMapping()
    public List<Rent> getAll() {
        System.out.println("Inside Home Controller");

        return rentService.getAllRents();
    }

    @PostMapping("/add")
    public Rent add(@RequestBody Rent rent) {
        return rentService.addRent(rent);
    }
}