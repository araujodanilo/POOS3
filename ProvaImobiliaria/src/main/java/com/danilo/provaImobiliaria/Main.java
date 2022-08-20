package com.danilo.provaImobiliaria;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Declarando todos tipo de pessoas

        // Declarando Proetarios (polimorfismo)

        Pessoa proprietario1 = new Proprietario("25483118200", "José", "16979797979", "Santander", "123841");
        Pessoa proprietario2 = new Proprietario("51649844121", "Mauricio", "16977754877", "Itaú", "123765x");
        Pessoa proprietario3 = new Proprietario("49481555795", "Fernando", "11559200025", "Banco do Basil", "123547");

        // Declarando Inquilinos (polimorfismo)

        Pessoa inquilino1 = new Inquilino("51848825155", "Antônio", "11559200025", 1400);
        Pessoa inquilino2 = new Inquilino("15681205488", "Maria", "64681386786", 5000);
        Pessoa inquilino3 = new Inquilino("41318795124", "Rafaela", "12357842231", 10000);
        Pessoa inquilino4 = new Inquilino("21547812156", "Ivone", "98754612305", 1500);
        Pessoa inquilino5 = new Inquilino("87456487567", "Gabriel", "87987442318", 1800);

        // Declarando Corretores (polimorfismo)

        Pessoa corretor1 = new Corretor("55641231568", "Murilo", "87987442318", "Nao sei o que é", 200);
        Pessoa corretor2 = new Corretor("21135538784", "Thais", "87987442318", "Nao sei o que é 2", 300);
        Pessoa corretor3 = new Corretor("65461347889", "Isabela", "87987442318", "Nao sei o que é 3", 150);

        // Lista com todos tipos de pessoas e logo adicionando

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(proprietario1);
        pessoas.add(proprietario2);
        pessoas.add(proprietario3);
        pessoas.add(inquilino1);
        pessoas.add(inquilino2);
        pessoas.add(inquilino3);
        pessoas.add(inquilino4);
        pessoas.add(inquilino5);
        pessoas.add(corretor1);
        pessoas.add(corretor2);
        pessoas.add(corretor3);

        // ---------------------------------------------------------------

        // Declarando todos tipos de imveis (polimorfismo)

        Imovel casa1 = new Casa((Proprietario) proprietario1, "Coronel joaqim cintra", 600, 1, 1200, "Dado 1", "1");
        Imovel casa2 = new Casa((Proprietario) proprietario3, "Coronel joaqim cintra", 550, 2, 1000, "Dado 1", "2");

        Imovel apartamento1 = new Apartamento((Proprietario) proprietario2, "Francisco de Assis", 200, 1,800,"Bela Vista", 2);
        Imovel apartamento2 = new Apartamento((Proprietario) proprietario3, "Antonio Blanco", 300, 1,2400,"Del Rey", 15);
        Imovel apartamento3 = new Apartamento((Proprietario) proprietario1, "Francisco de Assis", 250, 1,900,"Bela Vista", 5);

        // Lista com os imoveis

        List<Imovel> imoveis = new ArrayList<>();

        imoveis.add(casa1);
        imoveis.add(casa2);
        imoveis.add(apartamento1);
        imoveis.add(apartamento2);
        imoveis.add(apartamento3);

        // ---------------------------------------------------------------

        // Criando dados de alugueis

        Aluguel aluguel1 = new Aluguel("01/01/2020", "12/12/2022", 1, apartamento1,(Inquilino) inquilino1, (Corretor) corretor1);
        Aluguel aluguel2 = new Aluguel("01/01/2020", "12/12/2022", 1, casa1,(Inquilino) inquilino2, (Corretor) corretor2);
        Aluguel aluguel3 = new Aluguel("01/01/2020", "12/12/2022", 1, apartamento2,(Inquilino) inquilino3, (Corretor) corretor3);
        Aluguel aluguel4 = new Aluguel("01/01/2020", "12/12/2022", 1, casa2,(Inquilino) inquilino4, (Corretor) corretor2);
        Aluguel aluguel5 = new Aluguel("01/01/2020", "12/12/2022", 1, apartamento3,(Inquilino) inquilino5, (Corretor) corretor1);


        // Lista de alugueis

        List<Aluguel> alugueis= new ArrayList<>();

        alugueis.add(aluguel1);
        alugueis.add(aluguel2);
        alugueis.add(aluguel3);
        alugueis.add(aluguel4);
        alugueis.add(aluguel5);

        System.out.println("Pessoas: ");
        for (Pessoa p : pessoas){
            p.mostrarDadosPessoas();
        }

        System.out.println("\nImoveis: ");
        for (Imovel i : imoveis){
            i.mostrarDadosImovel();
        }

        System.out.println("\nAlugeis: ");
        for (Aluguel a : alugueis){
            a.mostrarDadosAluguel();
        }
    }
}
