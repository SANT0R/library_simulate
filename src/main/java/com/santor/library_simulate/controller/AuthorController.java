package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.AuthorDTO;
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

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


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
    public List<AuthorDTO> getAll() {

        return authorService.getAll();
    }

    @PostMapping("/getAllById")
    public List<AuthorDTO> getAllById(@RequestBody List<AuthorDTO> list) {

        return authorService.getAllById(list);
    }

    @PostMapping("/getById")
    public AuthorDTO getById(@RequestBody Long id) {

        return authorService.getById(id);
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {

        authorService.deleteAll();
        return "done";
    }

    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<AuthorDTO> list) {

        authorService.deleteAllById(list);
        return "done";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Author author) {

        authorService.deleteById(author);

        return "done";
    }

    @PostMapping("/update")
    public String update(@RequestBody Author author) {

        authorService.update(author);

        return "done";
    }

    @PostMapping("/add")
    public String add(@RequestBody Author author) {

        authorService.add(author);

        return "done";
    }


}