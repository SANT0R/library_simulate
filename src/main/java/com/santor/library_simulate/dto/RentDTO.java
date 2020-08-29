package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class RentDTO extends BaseDTO {


    private LocalDate startDate;

    private LocalDate finishDate;

    private LocalDate returnDate;

    private Set<Book> books = new HashSet<>();

    private Client client;

}
