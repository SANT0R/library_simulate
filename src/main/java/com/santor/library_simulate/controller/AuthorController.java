package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.AuthorDTO;
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


import com.santor.library_simulate.model.Author;
import com.santor.library_simulate.service.AuthorService;
import org.springframework.web.servlet.ModelAndView;

@Api(value="post", description=" Post Operations Service")


@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @ApiOperation(value = "View a list of available posts",response = Iterable.class)
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
    @ApiOperation(value = "Get all author")
    @GetMapping("/")
    public List<AuthorDTO> getAll() {

        return authorService.getAll();
    }


    @ApiOperation(value = "Get authors by id")
    @PostMapping("/getAllById")
    public List<AuthorDTO> getAllById(@RequestBody List<AuthorDTO> list) {

        return authorService.getAllById(list);
    }


    @ApiOperation(value = "Get a author by id")
    @PostMapping("/getById")
    public AuthorDTO getById(@RequestBody Long id) {

        return authorService.getById(id);
    }


    @ApiOperation(value = "Delete all author")
    @PostMapping("/deleteAll")
    public String deleteAll() {

        authorService.deleteAll();
        return "done";
    }


    @ApiOperation(value = "Delete authors by id")
    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<AuthorDTO> list) {

        authorService.deleteAllById(list);
        return "done";
    }


    @ApiOperation(value = "Delete a author")
    @PostMapping("/delete")
    public String delete(@RequestBody Author author) {

        authorService.deleteById(author);

        return "done";
    }


    @ApiOperation(value = "Update a author")
    @PostMapping("/update")
    public String update(@RequestBody Author author) {

        authorService.update(author);

        return "done";
    }


    @ApiOperation(value = "Add a author")
    @PostMapping("/add")
    public String add(@RequestBody Author author) {

        authorService.add(author);

        return "done";
    }


}