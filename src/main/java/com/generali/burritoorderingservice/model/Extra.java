package com.generali.burritoorderingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Extra {
    @Id
    @GeneratedValue
    private Long id;

    //TODO:may consider to use enum to limit options to avocado.
    //However, it comes with the cost if we need to add or remove option(s) in future.
    private String type;

    protected Extra(){}

    public Extra(String type){
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private TheOrder theOrder;
}
