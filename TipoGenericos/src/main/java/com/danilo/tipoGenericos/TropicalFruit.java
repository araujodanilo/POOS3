package com.danilo.tipoGenericos;

public class TropicalFruit extends  Fruit{

    public TropicalFruit(String name) {
        super(name);
    }

    @Override
    public  String toString() {

        return "Fruta Tropical: "+this.name+", brow!";
    }
}
