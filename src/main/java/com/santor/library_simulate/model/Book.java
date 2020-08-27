package com.santor.library_simulate.model;


import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Book extends BaseModel {

    private static final long serialVersionUID = -7599045333722607430L;
    @Column(nullable = false)
    private String fullName = "Name Surname";

    @Column(nullable = false)
    private String publisher = "Name";

    @Column(nullable = false)
    private LocalDate releaseYear = LocalDate.now();

    private String type = "Type";

    private String description = "Description";

    @Column(nullable = false)
    private int page = 0;

    @Column(nullable = false)
    private int stock = 0;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private  Author author;

    @ManyToMany(mappedBy = "books", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Rent> rents = new HashSet<>();


}
