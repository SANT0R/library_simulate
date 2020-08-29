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
public class Rent extends BaseModel {

    private static final long serialVersionUID = 6756764858273649500L;
    @Column(nullable = false)
    private LocalDate startDate = LocalDate.now();

    @Column(nullable = false)
    private LocalDate finishDate = LocalDate.now();

    private LocalDate returnDate ;

    @ManyToMany()
    private Set<Book> books = new HashSet<>();

    @ManyToOne
    private Client client;

}
