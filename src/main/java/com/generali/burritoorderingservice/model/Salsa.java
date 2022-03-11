package com.generali.burritoorderingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Salsa {
    @Id
    @GeneratedValue
    private Long id;

    private String spicyLevel;

    protected Salsa(){}

    public Salsa(String spicyLevel){
        this.spicyLevel = spicyLevel;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private TheOrder theOrder;
}
