package com.santor.library_simulate.dto.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 2263708886354994555L;
    private Long id;

}
