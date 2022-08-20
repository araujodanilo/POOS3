package com.danilo.copadomundo;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String pais;
    private int quantidadeTitulos;
    private List<Jogador> jogadores = new ArrayList<>();

    public Time(String pais, int quantidadeTitulos) {
        this.pais = pais;
        this.quantidadeTitulos = quantidadeTitulos;
    }

    public String getPais() {
        return pais;
    }

    public void adicionarJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQuantidadeTitulos() {
        return quantidadeTitulos;
    }

    public void setQuantidadeTitulos(int quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }
}
