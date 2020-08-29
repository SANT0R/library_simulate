package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Author;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookDTO extends BaseDTO {

    private static final long serialVersionUID = 3983723742950421458L;
    private String fullName;

    private String publisher;

    private LocalDate releaseYear;

    private String type;

    private String description;

    private int page;

    private int stock;

    private Author author;


}
