package com.generali.burritoorderingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Tortilla {
    @Id
    @GeneratedValue
    private Long id;

    //TODO:may consider to use enum to limit options to corn, and flour.
    //However, it comes with the cost if we need to add or remove option(s) in future.
    private String type;

    protected Tortilla(){}

    public Tortilla(String type){
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private TheOrder theOrder;
}
