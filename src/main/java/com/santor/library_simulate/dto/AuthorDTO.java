package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Book;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AuthorDTO extends BaseDTO {

    private String fullName;
    private Set<Book> books = new HashSet<>();
}
