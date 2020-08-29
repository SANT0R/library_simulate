package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Author;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO extends BaseDTO {

    private String fullName;

    private String publisher;

    private LocalDate releaseYear;

    private String type;

    private String description;

    private int page;

    private int stock;

    private Author author;


}
