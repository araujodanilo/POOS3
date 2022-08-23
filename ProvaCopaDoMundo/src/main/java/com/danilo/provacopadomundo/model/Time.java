package com.danilo.provacopadomundo.model;

public class Time implements IMostrarDados{
    private int idTime;
    private String pais;

    public Time(int idTime, String pais) {
        this.idTime = idTime;
        this.pais = pais;
    }

    public Time(String pais) {
        this.pais = pais;
    }

    public Time() {
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void mostrarDados() {
        System.out.println("ID: " + this.getIdTime());
        System.out.println("Nome Time: " + this.getPais());
        System.out.println("\n");

    }
}