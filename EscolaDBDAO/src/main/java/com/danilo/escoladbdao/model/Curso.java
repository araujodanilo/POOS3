package com.danilo.escoladbdao.model;

public class Curso implements IMostrarDados{
    private int idCurso;
    private String nome;

    public Curso(){
    }

    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrarDados(){
        System.out.println("Curso: " + this.getNome() + "\tID: " + this.getIdCurso());
    }
}
