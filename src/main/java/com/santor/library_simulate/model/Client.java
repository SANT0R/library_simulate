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
    private String password = "**************";

    @Column(nullable = false)
    private String phone = "+905*********";

    @Column(nullable = false)
    private String eMail = "someone@something.com";

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private Set<Rent> rents = new HashSet<>();

}
