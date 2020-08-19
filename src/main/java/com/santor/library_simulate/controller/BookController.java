package com.santor.library_simulate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.santor.library_simulate.dto.BookDTO;
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

import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.service.BookService;
import org.springframework.web.servlet.ModelAndView;

@Api(value="post")
@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

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

    @ApiOperation(value = "Get all book")
    @GetMapping("/")
    public List<BookDTO> getAll() {

        return bookService.getAll();
    }

    @ApiOperation(value = "Get books by id")
    @PostMapping("/getAllById")
    public List<BookDTO> getAllById(@RequestBody List<BookDTO> list) {

        return bookService.getAllById(list);
    }

    @ApiOperation(value = "Get book by id")
    @PostMapping("/getById")
    public BookDTO getById(@RequestBody Long id) {

        return bookService.getById(id);
    }

    @ApiOperation(value = "Delete all book")
    @PostMapping("/deleteAll")
    public String deleteAll() {

        bookService.deleteAll();
        return "done";
    }

    @ApiOperation(value = "Delete books by id")
    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestBody List<BookDTO> list) {

        bookService.deleteAllById(list);
        return "done";
    }

    @ApiOperation(value = "Delete  book by id")
    @PostMapping("/delete")
    public String delete(@RequestBody Book book) {

        bookService.deleteById(book);

        return "done";
    }

    @ApiOperation(value = "Update a book")
    @PostMapping("/update")
    public String update(@RequestBody Book book) {

        bookService.update(book);

        return "done";
    }

    @ApiOperation(value = "Add a book")
    @PostMapping("/add")
    public String add(@RequestBody Book book) {

        bookService.add(book);

        return "done";
    }


}