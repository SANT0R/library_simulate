package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
/*
@EnableJpaRepositories
*/
public class Rent extends BaseModel {

    private static final long serialVersionUID = 6756764858273649500L;
    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date finishDate;

    private Date returnDate = finishDate;

    @ManyToMany(mappedBy = "rent")
    private Set<Book> books = new HashSet<>();

    @ManyToOne
    private Client client;

}
