package com.danilo.copadomundo;

public class Partida {
    private String data;
    private String hora;
    private int placarTime1;
    private int placarTime2;
    private Estadio estadio;
    private Time time1;
    private Time time2;

    public Partida(String data, String hora, Estadio estadio, Time time1, Time time2) {
        this.data = data;
        this.hora = hora;
        this.estadio = estadio;
        this.time1 = time1;
        this.time2 = time2;
    }

    public void atualizarResultado(int placarTime1, int placarTime2){
        this.placarTime1 = placarTime1;
        this.placarTime2 = placarTime2;
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

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getPlacarTime1() {
        return placarTime1;
    }

    public int getPlacarTime2() {
        return placarTime2;
    }

}
