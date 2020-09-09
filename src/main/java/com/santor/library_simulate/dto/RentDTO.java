package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Client;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class RentDTO extends BaseDTO {


    private static final long serialVersionUID = -8346283353054250213L;
    private LocalDate startDate;

    private LocalDate finishDate ;

    private LocalDate returnDate;

    private Set<BookDTO> books = new HashSet<>();

    private Client client;

}
