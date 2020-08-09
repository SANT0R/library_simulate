package com.santor.library_simulate.model;


import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
public class Book extends BaseModel {

    private String name;

    private String releaseYear;

    private String type;

    private String description;

    private int page;

    private int stock;

    @ManyToOne
    private com.santor.library_simulate.model.Author author;

    @OneToMany(mappedBy = "book")
    private Set<Rent> rents = new HashSet<>();

}
