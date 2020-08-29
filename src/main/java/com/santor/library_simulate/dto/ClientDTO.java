package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import lombok.Data;

@Data
public class ClientDTO extends BaseDTO {

    private String fullName;

    private String password;

    private String phone;

    private String eMail;


}
