package com.danilo.livrariaComArrayList;

public class ItensCompra {
    private Compra compra;
    private Livro livro;
    private int quantidade;
    private double valorParcial;

    public void calcularValorParcial(){
        this.valorParcial = this.quantidade * this.livro.getPreco();
    }

    public ItensCompra(){}

    public ItensCompra(Compra compra, Livro livro, int quantidade) {
        this.compra = compra;
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setValorParcial(double valorParcial) {
        this.valorParcial = valorParcial;
    }

    public double getValorParcial() {
        return this.valorParcial;
    }

    public void mostrarDados(){
        System.out.println("-=-=-=- Itens Compra -=-=-=-\n");
        calcularValorParcial();
        System.out.println("Qunatidade : " + this.quantidade + "\n");
        livro.mostrarDados();
        System.out.println("Valor parcial: " + this.valorParcial);
        System.out.println("-=-=-=- -=-=-=- -=-=-=-\n");


    }
}

