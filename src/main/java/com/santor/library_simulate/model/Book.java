package com.santor.library_simulate.model;


import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Book extends BaseModel {

    private String name;

    private String publisher;

    private String releaseYear;

    private String type;

    private String description;

    private int page;

    private int stock;

    @ManyToOne
    private com.santor.library_simulate.model.Author author;
/*
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Rent> rents = new HashSet<>();
*/
}
