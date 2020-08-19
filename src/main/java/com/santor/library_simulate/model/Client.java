package com.santor.library_simulate.model;

import com.santor.library_simulate.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
/*
@EnableJpaRepositories
 */
public class Client extends BaseModel {

    private static final long serialVersionUID = -1494977876606097432L;
    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private Set<Rent> rents = new HashSet<>();

}
