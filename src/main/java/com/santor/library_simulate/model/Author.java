package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Author extends BaseModel {

    private String fullName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

}
