package com.generali.burritoorderingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Vegetable {
    @Id
    @GeneratedValue
    private Long id;

    //TODO:may consider to use enum to limit options to cabbage, corn, and jalapeno.
    //However, it comes with the cost if we need to add or remove option(s) in future.
    private String name;

    protected Vegetable(){}

    public Vegetable(String name){
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private TheOrder theOrder;
}
