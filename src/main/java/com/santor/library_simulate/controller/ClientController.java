package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.ClientDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
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

@Api(value="post")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/home")
    public ModelAndView getHomePage() {

        var now = LocalDateTime.now();
        var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        var date_time = dtf.format(now);
        var params = new HashMap<String, Object>();
        params.put("date_time", date_time);

        return new ModelAndView("author", params);
    }

    @ApiOperation(value = "Get all client")
    @GetMapping("/")
    public List<ClientDTO> getAll() {

        return clientService.getAll();
    }

    @ApiOperation(value = "Get clients by id")
    @PostMapping("/getAllById")
    public List<ClientDTO> getAllById(@RequestBody List<ClientDTO> list) {

        return clientService.getAllById(list);
    }

    @ApiOperation(value = "Get a client by id")
    @PostMapping("/getById")
    public ClientDTO getById(@RequestBody Long id) {

        return clientService.getById(id);
    }

    @ApiOperation(value = "Delete all client")
    @PostMapping("/deleteAll")
    public String deleteAll() {

        clientService.deleteAll();
        return "done";
    }

    @ApiOperation(value = "Delete clients by id")
    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<ClientDTO> list) {

        clientService.deleteAllById(list);
        return "done";
    }

    @ApiOperation(value = "Delete a client by id")
    @PostMapping("/delete")
    public String delete(@RequestBody Client client) {

        clientService.deleteById(client);

        return "done";
    }

    @ApiOperation(value = "Update a client")
    @PostMapping("/update")
    public String update(@RequestBody Client client) {

        clientService.update(client);

        return "done";
    }

    @ApiOperation(value = "Add a client")
    @PostMapping("/add")
    public String add(@RequestBody Client client) {

        clientService.add(client);

        return "done";
    }


}