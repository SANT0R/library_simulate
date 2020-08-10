package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Rent;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
public class ClientDTO extends BaseDTO {

    private String clientName;

    private String password;

    private boolean enabled;

    private Set<Rent> rents = new HashSet<>();

}
