package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table
@Data
@Entity
public class Author extends BaseModel {

    private static final long serialVersionUID = -6351021095604979392L;
    @Column(nullable = false)
    private String fullName ;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

}
