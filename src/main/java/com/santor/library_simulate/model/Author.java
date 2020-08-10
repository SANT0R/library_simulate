package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Author extends BaseModel {

    private String fullName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

}
