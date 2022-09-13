package com.danilo.provacopadomundo.model;

public class Partida implements IMostrarDados{
    private int idPartida;
    private String dataJogo;
    private Time time1;
    private Time time2;
    private int placarTime1;
    private int placarTime2;

    public Partida() {
    }

    public Partida(int idPartida, String dataJogo, Time time1, Time time2, int placarTime1, int placarTime2) {
        this.idPartida = idPartida;
        this.dataJogo = dataJogo;
        this.time1 = time1;
        this.time2 = time2;
        this.placarTime1 = placarTime1;
        this.placarTime2 = placarTime2;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(String dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public int getPlacarTime1() {
        return placarTime1;
    }

    public int getPlacarTime2() {
        return placarTime2;
    }

    public void atualzarPlacar(int placarTime1, int placarTime2){
        this.placarTime1 = placarTime1;
        this.placarTime2 = placarTime2;
    }

    @Override
    public void mostrarDados() {
        System.out.println("ID Partida: " + this.idPartida);
        System.out.println("Time 1: " + this.time1.getPais() + "\tID: " + this.time1.getIdTime());
        System.out.println("Time 2: " + this.time2.getPais() + "\tID: " + this.time2.getIdTime());
        System.out.println("Placar " + this.time1.getPais() + ": " + this.placarTime1);
        System.out.println("Placar " + this.time2.getPais() + ": " + this.placarTime2);
    }
}
