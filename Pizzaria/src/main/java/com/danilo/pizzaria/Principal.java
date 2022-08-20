package com.danilo.pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Ingrediente ingrediente1 = new Ingrediente("Queijo");
        Ingrediente ingrediente2 = new Ingrediente("Presunto");
        Ingrediente ingrediente3 = new Ingrediente("Chedar");
        Ingrediente ingrediente4 = new Ingrediente("Calabresa");
        Ingrediente ingrediente5 = new Ingrediente("Frango");
        Ingrediente ingrediente6 = new Ingrediente("Requeijão");

        // Tem duas forma de adicionar ingredientes na pizza, uma no metodo setIngrediente (Enviar uma lista)

        List<Ingrediente> ingredienteList = new ArrayList<>();
        ingredienteList.add(ingrediente1);
        ingredienteList.add(ingrediente2);
        ingredienteList.add(ingrediente3);

        Bebida b1 = new Cerveja("Branha", 3.8,200,2.5);
        Bebida b2 = new Vinho("Del Branco", 25.0, 10, "UVA", "França");

        Pizza p1 = new Pizza("Tradicional", 21.5, false);
        p1.setIngredientes(ingredienteList);
        Pizza p2 = new Pizza("Frango", 30.5, true);
        p2.adicionarIngredientes(ingrediente4); // Proposital para teste do metodo retirarIngrediente da Pizza
        p2.adicionarIngredientes(ingrediente5);
        p2.adicionarIngredientes(ingrediente6);
        p2.retirarIngredientes(ingrediente4);


        //Prints


        System.out.println("Bebidas: ");
        b1.mostrarDados();
        b2.mostrarDados();

        System.out.println("Pizzas: ");
        p1.mostrarDados();
        p2.mostrarDados();



    }
}
