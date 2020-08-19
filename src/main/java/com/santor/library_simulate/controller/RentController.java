package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.RentDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@ApiOperation(value = "View a list of available posts",response = Iterable.class)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
}
)
@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentService rentService;

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
    public List<RentDTO> getAll() {

        return rentService.getAll();
    }

    @PostMapping("/getAllById")
    public List<RentDTO> getAllById(@RequestBody List<RentDTO> list) {

        return rentService.getAllById(list);
    }

    @PostMapping("/getById")
    public RentDTO getById(@RequestBody Long id) {

        return rentService.getById(id);
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {

        rentService.deleteAll();
        return "done";
    }

    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<RentDTO> list) {

        rentService.deleteAllById(list);
        return "done";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Rent rent) {

        rentService.deleteById(rent);

        return "done";
    }

    @PostMapping("/update")
    public String update(@RequestBody Rent rent) {

        rentService.update(rent);

        return "done";
    }

    @PostMapping("/add")
    public String add(@RequestBody Rent rent) {

        rentService.add(rent);

        return "done";
    }


}