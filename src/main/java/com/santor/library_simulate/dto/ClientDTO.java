package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import com.santor.library_simulate.model.Rent;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
public class ClientDTO extends BaseDTO {

    private String fullName;

    private String password;

    private String phone;

    private String eMail;


}
