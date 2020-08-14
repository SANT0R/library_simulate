package com.santor.library_simulate.model;


import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Table
@Entity
@Data
public class Book extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String releaseYear;

    private String type;

    private String description;

    @Column(nullable = false)
    private int page;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private  Author author;

    @ManyToMany(mappedBy = "book", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Rent> rents = new HashSet<>();

}
