package com.danilo.tipoGenericos;

public class Vegetable {
    protected String name;

    public Vegetable(String name){
        this.name = name;
    }

    @Override
    public  String toString() {
        return "Vegetal: "+this.name;
    }
}
