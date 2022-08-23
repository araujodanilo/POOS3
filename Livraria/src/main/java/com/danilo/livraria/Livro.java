package com.danilo.livraria;

import java.util.Arrays;

public class Livro {
    private String titulo;
    private int anoPublicado;
    private double preco;
    private Editora editora;
    private Autor[] autores = new Autor[5];

    public Livro() {
    }

    public Livro(String titulo, int anoPublicado, double preco, Editora editora, Autor[] autores) {
        this.titulo = titulo;
        this.anoPublicado = anoPublicado;
        this.preco = preco;
        this.editora = editora;
        this.autores = autores.clone();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Autor[] getAutor() {
        return autores;
    }

    public void setAutor(Autor[] autores) {
        this.autores = autores;
    }

    public void mostrarDados() {
        System.out.println();
        System.out.println("Titulo: " + this.titulo + "\nAno: " + this.anoPublicado + "\nPreço: " + this.preco);
        editora.mostrarDados();
        System.out.println("Autores:");
        for (Autor autor : autores){
            if (autor != null){
                autor.mostrarDados();
            }
        }
        System.out.println();
    }
}
