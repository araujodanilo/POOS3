package com.danilo.copadomundo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Time t1 = new Time("Brasil", 1);
        Time t2 = new Time("Mexico", 0);

        Jogador j1 = new Jogador("Danilo", "Meia", 10, t1);
        Jogador j2 = new Jogador("Jos�", "Goleiro", 1, t1);
        Jogador j3 = new Jogador("Murilo", "Zagueiro", 4, t2);

        t1.adicionarJogador(j1);
        t1.adicionarJogador(j2);
        t2.adicionarJogador(j3);

        System.out.println("Time 1 - Pais: " + t1.getPais() + " - Quantidade titulos: " + t1.getQuantidadeTitulos()); // Print via classe Time
        System.out.println("Time 2 - Pais: " + j2.getTime().getPais() + " - Quantidade titulos: " + j2.getTime().getQuantidadeTitulos()); // Print via classe Jogador(Navegabilidade)

        System.out.println("\nJogadores Time 1:");
        for (Jogador jogador : t1.getJogadores()){
            System.out.println("Jogador - Nome: " + jogador.getNome() + " - Posi��o: " + jogador.getPosicao() + " - Camisa: " + jogador.getNumeroCamisa() + " - Time Pa�s: " + jogador.getTime().getPais());
        }

        System.out.println("\nJogadores Time 2:");
        for (Jogador jogador : t2.getJogadores()){
            System.out.println("Jogador - Nome: " + jogador.getNome() + " - Posi��o: " + jogador.getPosicao() + " - Camisa: " + jogador.getNumeroCamisa() + " - Time Pa�s: " + jogador.getTime().getPais());
        }

        Estadio e1 = new Estadio("Vila Nova", "S?o Carlos");

        Partida p1 = new Partida("05/04/2022", "15:00", e1, t1, t2);

        System.out.println("\nPartida 1 - Hora: " + p1.getHora() + " - Data: " + p1.getData() + " - Estadio: " + p1.getEstadio().getNome() + " - Local: " + p1.getEstadio().getCidade());
        System.out.println(p1.getTime1().getPais() + " X " + p1.getTime2().getPais());

        p1.atualizarResultado(2, 0);

        System.out.println("\nResultado: " + p1.getTime1().getPais() + " " + p1.getPlacarTime1() + " X " + p1.getPlacarTime2() + " " + p1.getTime2().getPais());

    }
}
