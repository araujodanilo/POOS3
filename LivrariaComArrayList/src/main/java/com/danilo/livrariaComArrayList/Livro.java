package com.danilo.livrariaComArrayList;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private Editora editora;
    private int anoPublicacao;
    private double preco;
    private List<Autor> autores = new ArrayList<>();

    public Livro(){

    }

    public Livro(String titulo, int anoPublicacao, double preco, List<Autor> autores, Editora editora) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.autores = autores;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void mostrarDados(){
        System.out.println("------ Livro ------");

        System.out.println("Titulo: " + this.titulo + "\nAno: " + this.anoPublicacao + "\nPreço: " + this.preco + "\n");
        editora.mostrarDados();
        System.out.println("\n*-*-*-*-* Autores *-*-*-*-*");
        for (Autor a : this.autores){
            System.out.println();
            a.mostrarDados();
            System.out.println();
        }
        System.out.println("*-*-*-*-* *-*-*-*-* *-*-*-*-*\n");
        System.out.println("------ ------ ------");

    }
}
