package com.danilo.tipoGenericos;

public class Fruit extends Vegetable {
    public Fruit(String name){
        super(name);
    }

    @Override
    public  String toString() {

        return "Fruta: "+this.name;
    }
}
