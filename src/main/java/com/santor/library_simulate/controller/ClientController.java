package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Book;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.service.ClientService;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/home")
    public ModelAndView getHomePage() {

        var now = LocalDateTime.now();
        var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        var date_time = dtf.format(now);
        var params = new HashMap<String, Object>();
        params.put("date_time", date_time);

        return new ModelAndView("author", params);
    }

    @GetMapping("/")
    public List<ClientDTO> getAll() {

        return clientService.getAll();
    }

    @PostMapping("/getAllById")
    public List<ClientDTO> getAllById(@RequestBody List<ClientDTO> list) {

        return clientService.getAllById(list);
    }

    @PostMapping("/getById")
    public ClientDTO getById(@RequestBody Long id) {

        return clientService.getById(id);
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {

        clientService.deleteAll();
        return "done";
    }

    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<ClientDTO> list) {

        clientService.deleteAllById(list);
        return "done";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Client client) {

        clientService.deleteById(client);

        return "done";
    }

    @PostMapping("/update")
    public String update(@RequestBody Client client) {

        clientService.update(client);

        return "done";
    }

    @PostMapping("/add")
    public String add(@RequestBody Client client) {

        clientService.add(client);

        return "done";
    }


}