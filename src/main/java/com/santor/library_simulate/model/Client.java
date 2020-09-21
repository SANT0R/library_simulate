package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.UserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Client extends UserModel {

    private static final long serialVersionUID = -6858890208229888077L;
    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private Set<Rent> rents = new HashSet<>();

}
