package com.danilo.livraria;

public class ItensCompra {
    private int quantidade;
    private double valorParcial;
    private Livro livro;
    public ItensCompra() {
    }

    public ItensCompra(int quantidade, Livro livro) {
        this.quantidade = quantidade;
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(double valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void calcularValorParcial(){
        this.setValorParcial(this.getQuantidade()*this.getLivro().getPreco());
    }

    public void mostrarDados() {
        System.out.println("Quantidade: " + this.quantidade + "\nValor Parcial: " + this.valorParcial);
        livro.mostrarDados();
    }
}
