package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Table
@Entity
@Data
public class Client extends BaseModel {

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private Set<Rent> rents = new HashSet<>();

}
