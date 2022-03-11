package com.generali.burritoorderingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Protein {
    @Id
    @GeneratedValue
    private Long id;

    //TODO:may consider to use enum to limit options to steak, shrimp, pork, chicken, beef, and bean.
    //@Enumerated(EnumType.STRING)
    //However, it comes with the cost (code change, break existing data) if we need to add or remove option(s) in future.
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private TheOrder theOrder;

    protected Protein(){}

    public Protein(String type){
        this.type = type;
    }

}
