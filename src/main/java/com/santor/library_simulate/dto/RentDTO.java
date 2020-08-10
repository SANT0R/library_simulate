package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Client;
import lombok.Data;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
public class RentDTO extends BaseDTO {


    private Date start_date;

    private Date finishDate;

    private Date returnDate;

    private List<Book> books;

    private Client client;

}
