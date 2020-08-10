package com.santor.library_simulate.controller;

import java.util.List;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import com.santor.library_simulate.model.Author;
        import com.santor.library_simulate.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping()
    public List<Author> getAll() {
        System.out.println("Inside Home Controller");

        return authorService.getAllAuthors();
    }

    @PostMapping("/add")
    public Author add(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
}