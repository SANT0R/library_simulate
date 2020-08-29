package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientDTO extends BaseDTO {

    private static final long serialVersionUID = -5630358718907710394L;
    private String fullName;

    private String password;

    private String phone;

    private String eMail;


}
