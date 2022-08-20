package com.danilo.escoladbdao.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cidade implements IMostrarDados{
    private int idCidade;
    private String nome;

    public Cidade(int idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
    }

    public Cidade(){}

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public void mostrarDados(){
        System.out.println("Cidade: "+this.getNome()+"\tID: "+this.getIdCidade());
    }
}
