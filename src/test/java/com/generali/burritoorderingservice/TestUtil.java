package com.generali.burritoorderingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generali.burritoorderingservice.model.*;

public class TestUtil {

    public static TheOrder buildOrder(String desc){
        //TODO: Builder would make this look cleaner.
        TheOrder theOrder = new TheOrder(desc);
        Protein protein = new Protein("Chicken");
        theOrder.setProtein(protein);
        Tortilla tortilla = new Tortilla("corn");
        theOrder.setTortilla(tortilla);
        Salsa salsa = new Salsa("hot");
        theOrder.setSalsa(salsa);
        Vegetable cabbage = new Vegetable("cabbage");
        theOrder.addVegetable(cabbage);
        Extra avocado = new Extra("avocado");
        theOrder.addExtra(avocado);
        return theOrder;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
