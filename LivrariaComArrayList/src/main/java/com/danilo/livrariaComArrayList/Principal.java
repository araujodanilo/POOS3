package com.danilo.livrariaComArrayList;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Editora e1 = new Editora("Pearson", "10123123000112");
        Editora e2 = new Editora("Novatec", "99123123000115");

        Autor a1 = new Autor("Paul Deitel", "12345678");
        Autor a2 = new Autor("Harvey Deitel", "98764532");
        Autor a3 = new Autor("Peter Junior", "10293847");

        //List<Autor> autoresJava = new ArrayList<>(); # Essa forma tambem da certo e é mais recomendada!

        ArrayList<Autor> autoresJava = new ArrayList<>();

        autoresJava.add(a1);
        autoresJava.add(a2);

        Livro l1 = new Livro("Como Programar", 2016, 350.00, autoresJava, e1);
        Livro l2 = new Livro("Guia Programador", 2021, 120.00, new ArrayList<>(List.of(a3)), e2);

        Cliente cli = new Cliente("Maria", "12345678910");
        Compra compra1 = new Compra("Compra1", "15/03/2022", cli);

        ItensCompra itensCompra1 = new ItensCompra(compra1, l1, 2);
        itensCompra1.calcularValorParcial();

        ItensCompra itensCompra2 = new ItensCompra(compra1, l2, 1);
        itensCompra2.calcularValorParcial();

        compra1.setItensCompras(List.of(itensCompra1, itensCompra2));

        compra1.calcularValorTotalCompra();
        compra1.mostrarDados();


    }


}