package com.santor.library_simulate.dto.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseDTO implements Serializable {

    private Long id;

}
