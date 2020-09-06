package com.santor.library_simulate.model;


import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Book extends BaseModel {

    private static final long serialVersionUID = -7599045333722607430L;
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private LocalDate releaseYear;

    private String type;

    private String description;

    @Column(nullable = false)
    private int page;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private  Author author;

    @ManyToMany(mappedBy = "books", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Rent> rents = new HashSet<>();


}
