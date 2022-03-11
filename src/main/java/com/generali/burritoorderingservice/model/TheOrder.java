package com.generali.burritoorderingservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//TODO: order is reserved word for H2 so need to find a better name. Using TheOrder for now.
//TODO: Using @Builder but need to do some workaround to make JPA happy.
@Getter
@Setter
@Entity
public class TheOrder {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    protected TheOrder(){}

    public TheOrder(String description){
        this.description = description;
    }

    @OneToOne(mappedBy = "theOrder", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Protein protein;

    @OneToOne(mappedBy = "theOrder", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Tortilla tortilla;

    @OneToOne(mappedBy = "theOrder", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Salsa salsa;

    @OneToMany(mappedBy = "theOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Vegetable> vegetables = new HashSet<>();

    public void addVegetable(Vegetable vegetable){
        vegetables.add(vegetable);
        vegetable.setTheOrder(this);
    }

    public void removeVegetable(Vegetable vegetable){
        vegetables.remove(vegetable);
        vegetable.setTheOrder(null);
    }

    @OneToMany(mappedBy = "theOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Extra> extras = new HashSet<>();

    public void addExtra(Extra extra){
        extras.add(extra);
        extra.setTheOrder(this);
    }

    public void removeExtra(Extra extra){
        extras.remove(extra);
        extra.setTheOrder(null);
    }

}
