package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Table
@Entity
@Data
public class Rent extends BaseModel {

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date finishDate;

    private Date returnDate = finishDate;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "client")
    private List<Book> books;


    @Column(nullable = false)
    @ManyToOne
    private Client client;

}
