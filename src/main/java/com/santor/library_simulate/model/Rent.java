package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Rent extends BaseModel {

    private static final long serialVersionUID = 6756764858273649500L;
    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date finishDate;

    private Date returnDate = finishDate;

    @ManyToMany()
    private Set<Book> books = new HashSet<>();



    @ManyToOne
    private Client client;

}
