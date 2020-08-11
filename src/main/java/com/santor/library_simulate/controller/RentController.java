package com.santor.library_simulate.controller;

import java.util.List;

import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santor.library_simulate.model.Rent;
import com.santor.library_simulate.service.RentService;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentService rentService;

    @GetMapping()
    public List<RentDTO> getAll() {
        System.out.println("Inside Home Controller");

        return rentService.getAllRents();
    }

    public List<RentDTO> getById() {
        System.out.println("Inside Home Controller");

        return rentService.getAllRents();
    }

    @PostMapping("/add")
    public String add(@RequestBody Rent rent) { return "done"; }

    @PostMapping("/delete")
    public String delete(@RequestBody Rent rent) { return "done"; }

    @PostMapping("/update")
    public String update(@RequestBody Rent rent) { return "done"; }


}