package com.santor.library_simulate.dto;

import com.santor.library_simulate.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorDTO extends BaseDTO {

    private static final long serialVersionUID = -6266526934789306046L;
    private String fullName;
}
