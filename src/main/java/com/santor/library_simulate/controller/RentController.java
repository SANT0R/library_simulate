package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.RentDTO;
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

import com.santor.library_simulate.model.Rent;
import com.santor.library_simulate.service.RentService;
import org.springframework.web.servlet.ModelAndView;

@Api(value="post")
@RequiredArgsConstructor
@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentService rentService;

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

    @ApiOperation(value = "Get all rent")
    @GetMapping("/")
    public List<RentDTO> getAll() {

        return rentService.getAll();
    }

    @ApiOperation(value = "Get rents by id")
    @PostMapping("/getAllById")
    public List<RentDTO> getAllById(@RequestBody List<RentDTO> list) {

        return rentService.getAllById(list);
    }

    @ApiOperation(value = "Get a rent by id")
    @PostMapping("/getById")
    public RentDTO getById(@RequestBody Long id) {

        return rentService.getById(id);
    }

    @ApiOperation(value = "Delete all rent")
    @PostMapping("/deleteAll")
    public String deleteAll() {

        rentService.deleteAll();
        return "done";
    }

    @ApiOperation(value = "Delete rents by id")
    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<RentDTO> list) {

        rentService.deleteAllById(list);
        return "done";
    }

    @ApiOperation(value = "Delete a rent")
    @PostMapping("/delete")
    public String delete(@RequestBody Rent rent) {

        rentService.deleteById(rent);

        return "done";
    }

    @ApiOperation(value = "Update a rent")
    @PostMapping("/update")
    public String update(@RequestBody Rent rent) {

        rentService.update(rent);

        return "done";
    }

    @ApiOperation(value = "Add a rent")
    @PostMapping("/add")
    public String add(@RequestBody Rent rent) {

        rentService.add(rent);

        return "done";
    }


}