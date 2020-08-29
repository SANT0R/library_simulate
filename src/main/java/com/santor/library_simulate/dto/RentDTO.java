package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import lombok.Data;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class RentDTO extends BaseDTO {


    private Date startDate;

    private Date finishDate;

    private Date returnDate;

    private Set<Book> books = new HashSet<>();

    private Client client;

}
