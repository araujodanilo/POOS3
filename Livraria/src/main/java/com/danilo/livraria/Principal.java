package com.danilo.livraria;

import java.lang.reflect.Array;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Gabriela", "1234567891014");
        Autor autor2 = new Autor("Rafaela", "1234567891016");

        Editora editora1 = new Editora("PageUP", "52148851751");
        Editora editora2 = new Editora("DownPage", "52148851751");


        Autor[] autores = new Autor[5];
        autores[0] = autor1;
        Livro livro1 = new Livro("Misterioso código", 2022, 20.0, editora1, autores);

        Livro livro2 = new Livro("Em busca do código", 2020, 12.0, editora2, autores);

        for(Autor a: autores){
            a = null;
        }

        autores[0] = autor2;
        autores[1] = autor1;
        Livro livro3 = new Livro("Em busca de arrumar computador!", 2001, 50.0, editora1, autores);

        ItensCompra[] itensCompras = new ItensCompra[5];
        itensCompras[0] = new ItensCompra(5, livro1);
        itensCompras[1] = new ItensCompra(10, livro3);
        itensCompras[2] = new ItensCompra(1, livro2);

        itensCompras[0].calcularValorParcial();
        itensCompras[1].calcularValorParcial();
        itensCompras[2].calcularValorParcial();

        Cliente cliente = new Cliente("José", "12345678911");

        Compra compra = new Compra("1", "01/01/2022", itensCompras);

        compra.calcularValorTotal();

        compra.mostrarDados();
        for (ItensCompra itensCompra: compra.getItensCompra()){
            if (itensCompra != null){
                itensCompra.mostrarDados();
                itensCompra.getLivro().mostrarDados();
                System.out.println("----------------------------------");
            }
        }





    }
}
