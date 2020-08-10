package com.santor.library_simulate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    public List<Client> getAll() {
        System.out.println("Inside Home Controller");

        return clientService.getAllClients();
    }

    @PostMapping("/add")
    public Client add(@RequestBody Client client) {
        return clientService.addClient(client);
    }
}