package com.santor.library_simulate.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class UserDTO extends BaseDTO implements Serializable {


    private static final long serialVersionUID = -5630358718907710394L;

    private String userName ;

    private String fullName;

    private String password;

    private String phone;

    private String eMail;

}
