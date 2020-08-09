package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
public class Client extends BaseModel {

    private String clientName;

    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "client")
    private Set<Rent> rents = new HashSet<>();

}
