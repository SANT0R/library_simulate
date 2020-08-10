package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Rent;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
public class BookDTO extends BaseDTO {

    private String name;

    private String publisher;

    private String releaseYear;

    private String type;

    private String description;

    private int page;

    private int stock;

    private com.santor.library_simulate.model.Author author;

    private Set<Rent> rents = new HashSet<>();

}
