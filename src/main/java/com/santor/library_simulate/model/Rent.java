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

    private Date start_date;

    private Date finishDate;

    private Date returnDate;

    @ManyToMany
    private List<Book> books;


    @ManyToOne
    private Client client;

}
