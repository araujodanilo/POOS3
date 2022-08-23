package com.danilo.provacopadomundofx.model;

public class Partida implements IMostrarDados{
    private int idPartida;
    private String dataJogo;
    private int placarTime1;
    private int placarTime2;
    private Time time1;
    private Time time2;

    public Partida() {
    }

    public Partida(String dataJogo, Time time1, Time time2) {
        this.dataJogo = dataJogo;
        this.time1 = time1;
        this.time2 = time2;
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

    public int getPlacarTime1() {
        return placarTime1;
    }

    public int getPlacarTime2() {
        return placarTime2;
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

    public void atualizarPlacar(int placarTime1, int placarTime2){
        this.placarTime1 = placarTime1;
        this.placarTime2 = placarTime2;
    }

    @Override
    public void mostrarDados() {
        System.out.println("ID Partida: " + this.getIdPartida());
        System.out.println("Data: " + this.getDataJogo());
        System.out.println(this.getTime1().getPais() + ": " + this.getPlacarTime1()+ " X " + this.getTime2().getPais() + ": " + this.getPlacarTime2());
        System.out.println("\n");
    }
}