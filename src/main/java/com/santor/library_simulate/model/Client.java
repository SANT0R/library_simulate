package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import io.swagger.models.properties.EmailProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Client extends BaseModel {

    private static final long serialVersionUID = -1494977876606097432L;
    @Column(nullable = false)
    private String fullName = "Name Surname";

    @Column(nullable = false)
    private Long phone = +905123456789L;

    @Column(nullable = false)
    private String eMail = "someone@something.com";

    @Column(nullable = false)
    private String password = "**************";

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private Set<Rent> rents = new HashSet<>();

}
