package com.danilo.interfacebanco;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements IPrint {
    private String nome;
    private  String cpf;
    private List<Produto> listaProdutos = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Produto> getListaProdutos(){
        return this.listaProdutos;
    }

    public void addListaProduto(Produto produto){
        this.listaProdutos.add(produto);
    }

    public void setListaProdutos(List<Produto> listaProdutos){
        this.listaProdutos = listaProdutos;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Nome: " + getNome() + "\nCPF: " +getCpf() + "\n");
    }
}
